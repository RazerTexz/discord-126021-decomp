package com.discord.widgets.share;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.ViewImageBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$Adapter$ViewHolder extends RecyclerView$ViewHolder {
    private final ViewImageBinding binding;
    public final /* synthetic */ WidgetIncomingShare$Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$Adapter$ViewHolder(WidgetIncomingShare$Adapter widgetIncomingShare$Adapter, ViewImageBinding viewImageBinding) {
        super(viewImageBinding.a);
        m.checkNotNullParameter(viewImageBinding, "binding");
        this.this$0 = widgetIncomingShare$Adapter;
        this.binding = viewImageBinding;
    }

    public final void bind(Uri uri) {
        this.binding.a.setOnClickListener(new WidgetIncomingShare$Adapter$ViewHolder$bind$1(this, uri));
        this.binding.a.setImageURI(uri);
    }
}
