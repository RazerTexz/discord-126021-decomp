package com.discord.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import b.a.d.e;
import b.a.k.b;
import com.discord.media_picker.MediaPicker;
import com.discord.media_picker.RequestType;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppFragment$d extends o implements Function0<Unit> {
    public final /* synthetic */ AppFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFragment$d(AppFragment appFragment) {
        super(0);
        this.this$0 = appFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaPicker mediaPicker = MediaPicker.a;
        AppFragment appFragment = this.this$0;
        CharSequence charSequenceK = b.k(appFragment, 2131887663, new Object[0], null, 4);
        e eVar = new e(this);
        m.checkNotNullParameter(appFragment, "provider");
        m.checkNotNullParameter(charSequenceK, "chooserTitle");
        m.checkNotNullParameter("image/*", "mimeType");
        m.checkNotNullParameter(eVar, "onError");
        try {
            Uri uriA = mediaPicker.a(appFragment);
            PackageManager packageManager = appFragment.requireContext().getPackageManager();
            m.checkNotNullExpressionValue(packageManager, "provider.requireContext().packageManager");
            Intent intentB = b.a.l.b.b(packageManager, charSequenceK, uriA, "image/*");
            mediaPicker.c(appFragment.requireContext(), new Intent("android.media.action.IMAGE_CAPTURE"), uriA);
            try {
                appFragment.startActivityForResult(intentB, RequestType.CHOOSER.getCode$media_picker_release());
            } catch (ActivityNotFoundException unused) {
                throw new IOException("No application available for media picker.");
            }
        } catch (IOException e) {
            eVar.invoke(e);
        }
        return Unit.a;
    }
}
