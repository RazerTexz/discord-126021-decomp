package com.discord.app;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.k.b;
import com.discord.media_picker.MediaPicker$a;
import com.discord.media_picker.RequestType;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppFragment$c implements MediaPicker$a {
    public final /* synthetic */ AppFragment a;

    public AppFragment$c(AppFragment appFragment) {
        this.a = appFragment;
    }

    @Override // com.discord.media_picker.MediaPicker$a
    public void a(Exception exc) {
        m.checkNotNullParameter(exc, "e");
        b.a.d.m.h(this.a.getContext(), b.k(this.a, 2131896681, new Object[]{exc.getMessage()}, null, 4), 0, null, 12);
    }

    @Override // com.discord.media_picker.MediaPicker$a
    public void b(Uri uri, RequestType requestType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(requestType, "request");
        String mimeType$default = AttachmentUtilsKt.getMimeType$default(this.a.requireContext().getContentResolver(), uri, null, 4, null);
        if (requestType.ordinal() != 3) {
            this.a.onImageChosen(uri, mimeType$default);
        } else {
            this.a.onImageCropped(uri, mimeType$default);
        }
    }
}
