package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.b.a.FlexInputCoordinator;
import b.b.a.d.MediaCursorAdapter;
import com.discord.utilities.display.DisplayUtils;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MediaFragment extends Fragment {
    private static final int GRID_LAYOUT_SPAN_COUNT = 3;
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: compiled from: MediaFragment.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View j;
        public final /* synthetic */ MediaCursorAdapter k;
        public final /* synthetic */ MediaFragment l;
        public final /* synthetic */ FlexInputCoordinator m;

        /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaFragment.kt */
        public static final class C0370a extends Lambda implements Function0<Unit> {
            public C0370a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RecyclerView recyclerView = a.this.l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView);
                recyclerView.setLayoutManager(new GridLayoutManager(a.this.j.getContext(), 3));
                RecyclerView recyclerView2 = a.this.l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView2);
                recyclerView2.setAdapter(a.this.k);
                RecyclerView recyclerView3 = a.this.l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView3);
                recyclerView3.invalidateItemDecorations();
                return Unit.a;
            }
        }

        public a(View view, MediaCursorAdapter mediaCursorAdapter, MediaFragment mediaFragment, FlexInputCoordinator flexInputCoordinator) {
            this.j = view;
            this.k = mediaCursorAdapter;
            this.l = mediaFragment;
            this.m = flexInputCoordinator;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FlexInputCoordinator flexInputCoordinator = this.m;
            if (flexInputCoordinator != null) {
                flexInputCoordinator.requestMediaPermissions(new C0370a());
            }
        }
    }

    /* JADX INFO: compiled from: MediaFragment.kt */
    public static final class b implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaCursorAdapter f3167b;
        public final /* synthetic */ MediaFragment c;
        public final /* synthetic */ FlexInputCoordinator d;

        public b(View view, MediaCursorAdapter mediaCursorAdapter, MediaFragment mediaFragment, FlexInputCoordinator flexInputCoordinator) {
            this.a = view;
            this.f3167b = mediaCursorAdapter;
            this.c = mediaFragment;
            this.d = flexInputCoordinator;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            if (this.c.hasPermissions(MediaFragment.REQUIRED_PERMISSION)) {
                MediaCursorAdapter mediaCursorAdapter = this.f3167b;
                Context context = this.a.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                mediaCursorAdapter.b(contentResolver);
            }
            SwipeRefreshLayout swipeRefreshLayout = this.c.swipeRefreshLayout;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }
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

    public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        return new EmptyListAdapter(R.g.item_permission_storage, R.f.permissions_req_btn, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        this.selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        Fragment parentFragment = getParentFragment();
        ActivityResultCaller parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof FlexInputCoordinator)) {
            parentFragment2 = null;
        }
        FlexInputCoordinator flexInputCoordinator = (FlexInputCoordinator) parentFragment2;
        if (flexInputCoordinator != null) {
            SelectionAggregator selectionAggregatorB = flexInputCoordinator.b();
            SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator);
            selectionAggregatorB.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.f.list);
        Context context = viewInflate.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int iWidth = (int) (DisplayUtils.getScreenSize(context).width() / 3);
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator2 = this.selectionCoordinator;
        Intrinsics3.checkNotNull(selectionCoordinator2);
        MediaCursorAdapter mediaCursorAdapter = new MediaCursorAdapter(selectionCoordinator2, iWidth, iWidth);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(viewInflate.getContext(), 3));
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(mediaCursorAdapter);
            }
        } else {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(newPermissionsRequestAdapter(new a(viewInflate, mediaCursorAdapter, this, flexInputCoordinator)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new b(viewInflate, mediaCursorAdapter, this, flexInputCoordinator));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
        Intrinsics3.checkNotNull(selectionCoordinator);
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
