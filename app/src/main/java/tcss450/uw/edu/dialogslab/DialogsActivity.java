package tcss450.uw.edu.dialogslab;





import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.NotificationCompat;
import android.view.View;

public class DialogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }


    public void launch(View v) {
        DialogFragment fragment = null;
        if (v.getId() == R.id.fire_missiles_button) {
            fragment = new FireMissilesDialogFragment();
        } else if (v.getId() == R.id.list_button){
            fragment = new ListDialogFragment();
        } else if (v.getId() == R.id.multi_list_button) {
            fragment = new MultiListDialogFragment();
        } else if (v.getId() == R.id.custom_button) {
            fragment = new CustomDialogFragment();
        } else if (v.getId() == R.id.time_button) {
            fragment = new TimePickerDialogFragment();
        } else if (v.getId() == R.id.date_button) {
            fragment = new DatePickerDialogFragment();
        }
        if (fragment != null)
            fragment.show(getSupportFragmentManager(), "launch");
    }

    public void sendNotification(View view) {
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.b);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.a);
        mBuilder.setLargeIcon(bm);
        mBuilder.setContentTitle("Notification title");
        mBuilder.setContentText("Notification content");

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// notificationID allows you to update the notification later on.
        mNotificationManager.notify(001, mBuilder.build());

    }
}
