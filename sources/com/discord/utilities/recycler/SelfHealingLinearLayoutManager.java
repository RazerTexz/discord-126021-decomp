package com.discord.utilities.recycler;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import b.d.b.a.a;
import com.discord.app.AppLog;
import d0.g0.w;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelfHealingLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelfHealingLinearLayoutManager extends LinearLayoutManager {
    private final RecyclerView$Adapter<?> adapter;
    private final RecyclerView recyclerView;

    public /* synthetic */ SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView$Adapter recyclerView$Adapter, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, recyclerView$Adapter, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? false : z2);
    }

    public static final /* synthetic */ RecyclerView$Adapter access$getAdapter$p(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        return selfHealingLinearLayoutManager.adapter;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        return selfHealingLinearLayoutManager.recyclerView;
    }

    private final void logWarning(Throwable exception) {
        StringBuilder sbU = a.U("Triggered in adapter: ");
        sbU.append(this.adapter.getClass());
        AppLog.g.w("Invalid adapter configuration.", new Exception(sbU.toString(), exception));
    }

    private final void resetAdapter(Throwable exception) {
        this.recyclerView.post(new SelfHealingLinearLayoutManager$resetAdapter$1(this));
        logWarning(exception);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutChildren(RecyclerView$Recycler recycler, RecyclerView$State state) {
        String message;
        m.checkNotNullParameter(recycler, "recycler");
        m.checkNotNullParameter(state, "state");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IllegalArgumentException e) {
            resetAdapter(e);
        } catch (IndexOutOfBoundsException e2) {
            resetAdapter(e2);
        } catch (RuntimeException e3) {
            String message2 = e3.getMessage();
            if ((message2 == null || !w.contains$default((CharSequence) message2, (CharSequence) "trying to unhide", false, 2, (Object) null)) && ((message = e3.getMessage()) == null || !w.contains$default((CharSequence) message, (CharSequence) "trying to hide", false, 2, (Object) null))) {
                throw e3;
            }
            resetAdapter(e3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView$Adapter<?> recyclerView$Adapter, int i, boolean z2) {
        super(recyclerView.getContext(), i, z2);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(recyclerView$Adapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = recyclerView$Adapter;
    }
}
