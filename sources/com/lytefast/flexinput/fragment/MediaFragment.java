package com.lytefast.flexinput.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.b.a.b;
import b.b.a.d.h;
import com.discord.utilities.display.DisplayUtils;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MediaFragment extends Fragment {
    public static final MediaFragment$Companion Companion = new MediaFragment$Companion(null);
    private static final int GRID_LAYOUT_SPAN_COUNT = 3;
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    public static final /* synthetic */ SwipeRefreshLayout access$getSwipeRefreshLayout$p(MediaFragment mediaFragment) {
        return mediaFragment.swipeRefreshLayout;
    }

    public static final /* synthetic */ boolean access$hasPermissions(MediaFragment mediaFragment, String... strArr) {
        return mediaFragment.hasPermissions(strArr);
    }

    public static final /* synthetic */ void access$setSwipeRefreshLayout$p(MediaFragment mediaFragment, SwipeRefreshLayout swipeRefreshLayout) {
        mediaFragment.swipeRefreshLayout = swipeRefreshLayout;
    }

    private final boolean hasPermissions(String... requiredPermissionList) {
        int length = requiredPermissionList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            if (!(ContextCompat.checkSelfPermission(requireContext(), requiredPermissionList[i]) == 0)) {
                return false;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: getRecyclerView$flexinput_release, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public EmptyListAdapter newPermissionsRequestAdapter(View$OnClickListener onClickListener) {
        m.checkNotNullParameter(onClickListener, "onClickListener");
        return new EmptyListAdapter(R$g.item_permission_storage, R$f.permissions_req_btn, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        this.selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        Fragment parentFragment = getParentFragment();
        ActivityResultCaller parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof b)) {
            parentFragment2 = null;
        }
        b bVar = (b) parentFragment2;
        if (bVar != null) {
            SelectionAggregator selectionAggregatorB = bVar.b();
            SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
            m.checkNotNull(selectionCoordinator);
            selectionAggregatorB.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(R$g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R$f.list);
        Context context = viewInflate.getContext();
        m.checkNotNullExpressionValue(context, "context");
        int iWidth = (int) (DisplayUtils.getScreenSize(context).width() / 3);
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator2 = this.selectionCoordinator;
        m.checkNotNull(selectionCoordinator2);
        h hVar = new h(selectionCoordinator2, iWidth, iWidth);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(viewInflate.getContext(), 3));
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(hVar);
            }
        } else {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(newPermissionsRequestAdapter(new MediaFragment$a(viewInflate, hVar, this, bVar)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R$f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new MediaFragment$b(viewInflate, hVar, this, bVar));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
        m.checkNotNull(selectionCoordinator);
        selectionCoordinator.itemSelectionListener.unregister();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(true);
        }
    }

    public final void setRecyclerView$flexinput_release(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
