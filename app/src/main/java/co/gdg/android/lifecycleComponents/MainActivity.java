package co.gdg.android.lifecycleComponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity
    extends AppCompatActivity
    implements LifecycleOwner
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    @Override
    public Lifecycle getLifecycle()
    {
        return null;
    }
}
