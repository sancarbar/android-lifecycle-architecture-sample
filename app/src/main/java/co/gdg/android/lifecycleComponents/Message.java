package co.gdg.android.lifecycleComponents;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * @author Santiago Carrillo
 */

@Entity
public class Message
{
    public
    @PrimaryKey
    String id;

    public String body;

    public String sender;

    public Date sendDate;

}

