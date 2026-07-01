package com.discord.dialogs;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.utilities.images.MGImages;
import d0.z.d.m;

/* JADX INFO: compiled from: ImageUploadDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageUploadDialog$d implements View$OnClickListener {
    public final /* synthetic */ ImageUploadDialog j;
    public final /* synthetic */ String k;

    public ImageUploadDialog$d(ImageUploadDialog imageUploadDialog, String str) {
        this.j = imageUploadDialog;
        this.k = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context context = this.j.getContext();
        Uri uri = this.j.androidx.core.app.NotificationCompat$MessagingStyle$Message.KEY_DATA_URI java.lang.String;
        if (uri == null) {
            m.throwUninitializedPropertyAccessException(NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        }
        MGImages.requestDataUrl(context, uri, this.k, this.j.cropResultCallBack);
        this.j.dismiss();
    }
}
