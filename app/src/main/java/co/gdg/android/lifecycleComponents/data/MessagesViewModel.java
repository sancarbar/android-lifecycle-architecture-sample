package co.gdg.android.lifecycleComponents.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import co.gdg.android.lifecycleComponents.data.entity.Message;
import co.gdg.android.lifecycleComponents.data.model.Model;
import co.gdg.android.lifecycleComponents.data.model.RoomModel;

/**
 * @author Santiago Carrillo
 */

public class MessagesViewModel
    extends AndroidViewModel
{

    private LiveData<List<Message>> messages;

    private Model model;

    public MessagesViewModel( Application application )
    {
        super( application );
        model = new RoomModel( getApplication() );
        messages = model.getMessageDao().findAllMessages();
    }

    public LiveData<List<Message>> getMessages()
    {
        return messages;
    }

    public Model getModel()
    {
        return model;
    }
}
