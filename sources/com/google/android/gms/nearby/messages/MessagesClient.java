package com.google.android.gms.nearby.messages;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p333j.p334b.C4264a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessagesClient extends C3267b<C4264a> {
    public MessagesClient(Activity activity, C3266a<C4264a> c3266a, @Nullable C4264a c4264a, C3267b.a aVar) {
        super(activity, c3266a, c4264a, aVar);
    }

    /* JADX INFO: renamed from: f */
    public abstract Task<Void> mo5984f(@NonNull Message message, @NonNull PublishOptions publishOptions);

    /* JADX INFO: renamed from: g */
    public abstract Task<Void> mo5985g(@NonNull MessageListener messageListener, @NonNull SubscribeOptions subscribeOptions);

    /* JADX INFO: renamed from: h */
    public abstract Task<Void> mo5986h(@NonNull Message message);

    /* JADX INFO: renamed from: i */
    public abstract Task<Void> mo5987i(@NonNull MessageListener messageListener);
}
