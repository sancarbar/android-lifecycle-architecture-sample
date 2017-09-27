package co.gdg.android.lifecycleComponents.data.model;

import co.gdg.android.lifecycleComponents.data.dao.MessageDao;

/**
 * @author Santiago Carrillo
 */

public interface Model
{

    MessageDao getMessageDao();

}
