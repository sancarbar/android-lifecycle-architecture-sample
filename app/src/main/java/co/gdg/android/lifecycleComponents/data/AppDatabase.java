package co.gdg.android.lifecycleComponents.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import co.gdg.android.lifecycleComponents.data.dao.MessageDao;
import co.gdg.android.lifecycleComponents.data.entity.Message;

/**
 * @author Santiago Carrillo
 */

@Database( entities = { Message.class }, version = 1 )
@TypeConverters( { Converters.class } )
public abstract class AppDatabase
    extends RoomDatabase
{

    public static final String DATABASE_NAME = "messages-db";

    public abstract MessageDao messageDao();

}
