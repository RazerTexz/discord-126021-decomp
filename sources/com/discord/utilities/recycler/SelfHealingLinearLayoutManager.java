package com.discord.utilities.recycler;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelfHealingLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelfHealingLinearLayoutManager extends LinearLayoutManager {
    private final RecyclerView.Adapter<?> adapter;
    private final RecyclerView recyclerView;

    public /* synthetic */ SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView.Adapter adapter, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, adapter, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? false : z2);
    }

    private final void logWarning(Throwable exception) {
        StringBuilder sbU = outline.U("Triggered in adapter: ");
        sbU.append(this.adapter.getClass());
        AppLog.g.w("Invalid adapter configuration.", new Exception(sbU.toString(), exception));
    }

    private final void resetAdapter(Throwable exception) {
        this.recyclerView.post(new Runnable() { // from class: com.discord.utilities.recycler.SelfHealingLinearLayoutManager.resetAdapter.1
            @Override // java.lang.Runnable
            public final void run() {
                SelfHealingLinearLayoutManager.this.adapter.notifyDataSetChanged();
                SelfHealingLinearLayoutManager.this.recyclerView.invalidate();
            }
        });
        logWarning(exception);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        String message;
        Intrinsics3.checkNotNullParameter(recycler, "recycler");
        Intrinsics3.checkNotNullParameter(state, "state");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IllegalArgumentException e) {
            resetAdapter(e);
        } catch (IndexOutOfBoundsException e2) {
            resetAdapter(e2);
        } catch (RuntimeException e3) {
            String message2 = e3.getMessage();
            if ((message2 == null || !Strings4.contains$default((CharSequence) message2, (CharSequence) "trying to unhide", false, 2, (Object) null)) && ((message = e3.getMessage()) == null || !Strings4.contains$default((CharSequence) message, (CharSequence) "trying to hide", false, 2, (Object) null))) {
                throw e3;
            }
            resetAdapter(e3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter, int i, boolean z2) {
        super(recyclerView.getContext(), i, z2);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = adapter;
    }
}
