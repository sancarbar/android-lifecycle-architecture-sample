package co.gdg.android.lifecycleComponents.data.model;

import android.app.Application;
import android.arch.persistence.room.Room;

import co.gdg.android.lifecycleComponents.data.AppDatabase;
import co.gdg.android.lifecycleComponents.data.dao.MessageDao;

/**
 * @author Santiago Carrillo
 */

public class RoomModel
    implements Model
{

    AppDatabase database;

    public RoomModel( Application application )
    {
        database = Room.databaseBuilder( application, AppDatabase.class, AppDatabase.DATABASE_NAME ).build();
    }

    @Override
    public MessageDao getMessageDao()
    {
        return database.messageDao();
    }
}
