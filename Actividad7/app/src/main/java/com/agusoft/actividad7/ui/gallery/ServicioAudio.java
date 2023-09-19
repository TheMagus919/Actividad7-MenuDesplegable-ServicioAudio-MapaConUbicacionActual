package com.agusoft.actividad7.ui.gallery;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.agusoft.actividad7.R;

public class ServicioAudio extends Service {
    public ServicioAudio() {
    }

    private MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.musica_4_3_1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}