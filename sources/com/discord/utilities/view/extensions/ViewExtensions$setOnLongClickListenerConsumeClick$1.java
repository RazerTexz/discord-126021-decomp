package com.discord.utilities.view.extensions;

import android.view.View;
import android.view.View$OnLongClickListener;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$setOnLongClickListenerConsumeClick$1 implements View$OnLongClickListener {
    public final /* synthetic */ Function1 $onLongClick;

    public ViewExtensions$setOnLongClickListenerConsumeClick$1(Function1 function1) {
        this.$onLongClick = function1;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        Function1 function1 = this.$onLongClick;
        m.checkNotNullExpressionValue(view, "view");
        function1.invoke(view);
        ViewParent parent = view.getParent();
        while (true) {
            if (parent == null) {
                parent = null;
                break;
            }
            if (parent instanceof RecyclerView) {
                break;
            }
            parent = parent.getParent();
        }
        RecyclerView recyclerView = (RecyclerView) parent;
        if (recyclerView == null) {
            return true;
        }
        RecyclerViewExtensionsKt.ignoreCurrentTouch(recyclerView);
        return true;
    }
}
