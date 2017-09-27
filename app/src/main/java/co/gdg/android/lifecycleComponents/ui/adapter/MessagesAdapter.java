package co.gdg.android.lifecycleComponents.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.gdg.android.lifecycleComponents.R;
import co.gdg.android.lifecycleComponents.data.entity.Message;
import co.gdg.android.lifecycleComponents.util.DateUtil;

/**
 * @author Santiago Carrillo
 */

public class MessagesAdapter
    extends RecyclerView.Adapter<MessagesAdapter.ViewHolder>
{

    private List<Message> messageList;

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.message_row, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( MessagesAdapter.ViewHolder holder, int position )
    {
        Message message = messageList.get( position );
        holder.sender.setText( message.sender );
        holder.body.setText( message.body );
        holder.sendDate.setText( DateUtil.formatTime( "HH:mm", message.sendDate ) );
    }

    @Override
    public int getItemCount()
    {
        return messageList != null ? messageList.size() : 0;
    }

    public void updateItems( List<Message> messages )
    {
        this.messageList = messages;
        notifyDataSetChanged();
    }

    @SuppressWarnings( "WeakerAccess" )
    public static class ViewHolder
        extends RecyclerView.ViewHolder
    {

        @BindView( R.id.body )
        TextView body;

        @BindView( R.id.sender )
        TextView sender;

        @BindView( R.id.send_date )
        TextView sendDate;

        public ViewHolder( View view )
        {
            super( view );
            ButterKnife.bind( this, view );
        }
    }
}
