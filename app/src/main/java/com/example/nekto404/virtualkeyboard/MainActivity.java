package com.example.nekto404.virtualkeyboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nekto404.virtualkeyboard.VirtualButtons.VirtualButtons;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import timber.log.Timber;
@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStertCamera(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            MainActivityPermissionsDispatcher.performClickWithCheck(this);
        } else {
            openCamera();
        }
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    public void performClick() {
        openCamera();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    public void cameraNeverAskAgain() {
        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        openApplicationSettings();
    }

    protected void openApplicationSettings() {
        Intent appSettingsIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:"+ getPackageName()));
        startActivity(appSettingsIntent);
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    public void showRationaleForCamera(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setTitle("Досту до камери")
                .setMessage("Для роботи додатку необхідний доступ до камери")
                .setCancelable(false)
                .show();
    }

    public void openCamera(){
        Intent intent;
        intent = new Intent(this, VirtualButtons.class);
        startActivity(intent);
    }

}
