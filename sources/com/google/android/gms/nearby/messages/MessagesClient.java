package com.google.android.gms.nearby.messages;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.b;
import b.i.a.f.j.b.a;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessagesClient extends b<a> {
    public MessagesClient(Activity activity, b.i.a.f.e.h.a<a> aVar, @Nullable a aVar2, b.a aVar3) {
        super(activity, aVar, aVar2, aVar3);
    }

    public abstract Task<Void> f(@NonNull Message message, @NonNull PublishOptions publishOptions);

    public abstract Task<Void> g(@NonNull MessageListener messageListener, @NonNull SubscribeOptions subscribeOptions);

    public abstract Task<Void> h(@NonNull Message message);

    public abstract Task<Void> i(@NonNull MessageListener messageListener);
}
