package com.discord.media_picker;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* JADX INFO: compiled from: MediaPicker.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaPicker$Provider {
    File getImageFile();

    Context requireContext();

    void startActivityForResult(Intent intent, int requestCode);
}
