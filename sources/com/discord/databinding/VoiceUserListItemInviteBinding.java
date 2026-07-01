package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceUserListItemInviteBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public VoiceUserListItemInviteBinding(@NonNull LinearLayout linearLayout) {
        this.a = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
