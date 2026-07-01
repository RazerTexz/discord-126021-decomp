package com.discord.utilities.directories;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils$showServerOptions$2$1 implements View$OnClickListener {
    public final /* synthetic */ DirectoryUtils$showServerOptions$2 this$0;

    public DirectoryUtils$showServerOptions$2$1(DirectoryUtils$showServerOptions$2 directoryUtils$showServerOptions$2) {
        this.this$0 = directoryUtils$showServerOptions$2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.$removeGuildListener.invoke();
    }
}
