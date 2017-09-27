package co.gdg.android.lifecycleComponents.ui.activity;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.gdg.android.lifecycleComponents.R;
import co.gdg.android.lifecycleComponents.data.dao.MessageDao;
import co.gdg.android.lifecycleComponents.data.entity.Message;
import co.gdg.android.lifecycleComponents.data.model.Model;
import co.gdg.android.lifecycleComponents.data.model.RoomModel;
import co.gdg.android.lifecycleComponents.ui.adapter.MessagesAdapter;


public class MainActivity
    extends LifecycleActivity
{

    private final MessagesAdapter messagesAdapter = new MessagesAdapter();

    @BindView( R.id.recycler_view )
    RecyclerView recyclerView;

    @BindView( R.id.message_edit_text )
    EditText messageEditText;

    private Model model;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );
        configureRecyclerView();
        init();
        progressDialog = new ProgressDialog( this );
    }

    private void init()
    {
        AsyncTask.execute( new Runnable()
        {
            @Override
            public void run()
            {
                model = new RoomModel( getApplication() );
                model.getMessageDao().findAllMessages().observe( MainActivity.this, new Observer<List<Message>>()
                {
                    @Override
                    public void onChanged( @Nullable List<Message> messages )
                    {
                        messagesAdapter.updateItems( messages );
                        messageEditText.setText( null );
                        progressDialog.dismiss();
                    }
                } );
            }
        } );
    }

    private void configureRecyclerView()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout( true );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setAdapter( messagesAdapter );
    }

    public void onSendMessageClicked( View view )
    {
        progressDialog.show();
        final String messageBody = messageEditText.getText().toString();
        AsyncTask.execute( new Runnable()
        {
            @Override
            public void run()
            {
                Message message = new Message( messageBody );
                MessageDao messageDao = model.getMessageDao();
                messageDao.insertMessage( message );
            }
        } );
    }
}
