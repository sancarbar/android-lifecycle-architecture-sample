package co.gdg.android.lifecycleComponents;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by sancarbar on 3/7/18.
 */

public class CodeDemo
{

    public void main( List<String> urls )
    {
        try
        {
            String hostUrl = null;
            for ( String link : urls )
            {
                if ( link.contains( "https:" ) )
                {
                    hostUrl = link;
                    break;
                }
            }
            URL url = new URL( hostUrl );
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod( "GET" );
            connection.setDoOutput( true );
            connection.setConnectTimeout( 5000 );
            connection.setReadTimeout( 5000 );
            connection.connect();
            BufferedReader rd = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
            String content = "", line;
            while ( ( line = rd.readLine() ) != null )
            {
                content += line + "\n";
            }

        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
