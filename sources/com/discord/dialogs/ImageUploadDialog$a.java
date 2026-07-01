package com.discord.dialogs;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.media_picker.MediaPicker$Provider;
import com.discord.utilities.images.MGImages;
import d0.z.d.m;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ImageUploadDialog$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public ImageUploadDialog$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i != 0) {
            if (i != 1) {
                throw null;
            }
            ((ImageUploadDialog) this.k).dismiss();
            return;
        }
        Context context = ((ImageUploadDialog) this.k).getContext();
        MediaPicker$Provider mediaPicker$Provider = ((ImageUploadDialog) this.k).provider;
        if (mediaPicker$Provider == null) {
            m.throwUninitializedPropertyAccessException("provider");
        }
        Uri uri = ((ImageUploadDialog) this.k).androidx.core.app.NotificationCompat$MessagingStyle$Message.KEY_DATA_URI java.lang.String;
        if (uri == null) {
            m.throwUninitializedPropertyAccessException(NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        }
        MGImages.requestImageCrop$default(context, mediaPicker$Provider, uri, 0.0f, 0.0f, 0, 56, null);
        ((ImageUploadDialog) this.k).dismiss();
    }
}
