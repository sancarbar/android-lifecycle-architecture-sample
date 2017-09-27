package co.gdg.android.lifecycleComponents.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import co.gdg.android.lifecycleComponents.data.entity.Message;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author Santiago Carrillo
 */

@Dao
public interface MessageDao
{
    //CRUD
    @Insert( onConflict = IGNORE )
    void insertMessage( Message message );

    @Query( "SELECT * FROM Message ORDER BY sendDate DESC" )
    LiveData<List<Message>> findAllMessages();

    @Update( onConflict = REPLACE )
    void updateMessage( Message message );

    @Query( "DELETE from Message" )
    void deleteAll();


}
