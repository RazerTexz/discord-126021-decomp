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
import com.discord.utilities.display.DisplayUtils;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p076b.p077a.InterfaceC1429b;
import p007b.p076b.p077a.p079d.C1438h;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MediaFragment extends Fragment {
    private static final int GRID_LAYOUT_SPAN_COUNT = 3;
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$a */
    /* JADX INFO: compiled from: MediaFragment.kt */
    public static final class ViewOnClickListenerC11187a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ View f22073j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ C1438h f22074k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ MediaFragment f22075l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ InterfaceC1429b f22076m;

        /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$a$a */
        /* JADX INFO: compiled from: MediaFragment.kt */
        public static final class a extends AbstractC12240o implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RecyclerView recyclerView = ViewOnClickListenerC11187a.this.f22075l.getRecyclerView();
                C12238m.checkNotNull(recyclerView);
                recyclerView.setLayoutManager(new GridLayoutManager(ViewOnClickListenerC11187a.this.f22073j.getContext(), 3));
                RecyclerView recyclerView2 = ViewOnClickListenerC11187a.this.f22075l.getRecyclerView();
                C12238m.checkNotNull(recyclerView2);
                recyclerView2.setAdapter(ViewOnClickListenerC11187a.this.f22074k);
                RecyclerView recyclerView3 = ViewOnClickListenerC11187a.this.f22075l.getRecyclerView();
                C12238m.checkNotNull(recyclerView3);
                recyclerView3.invalidateItemDecorations();
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC11187a(View view, C1438h c1438h, MediaFragment mediaFragment, InterfaceC1429b interfaceC1429b) {
            this.f22073j = view;
            this.f22074k = c1438h;
            this.f22075l = mediaFragment;
            this.f22076m = interfaceC1429b;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            InterfaceC1429b interfaceC1429b = this.f22076m;
            if (interfaceC1429b != null) {
                interfaceC1429b.requestMediaPermissions(new a());
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$b */
    /* JADX INFO: compiled from: MediaFragment.kt */
    public static final class C11188b implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f22077a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C1438h f22078b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ MediaFragment f22079c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ InterfaceC1429b f22080d;

        public C11188b(View view, C1438h c1438h, MediaFragment mediaFragment, InterfaceC1429b interfaceC1429b) {
            this.f22077a = view;
            this.f22078b = c1438h;
            this.f22079c = mediaFragment;
            this.f22080d = interfaceC1429b;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            if (this.f22079c.hasPermissions(MediaFragment.REQUIRED_PERMISSION)) {
                C1438h c1438h = this.f22078b;
                Context context = this.f22077a.getContext();
                C12238m.checkNotNullExpressionValue(context, "context");
                ContentResolver contentResolver = context.getContentResolver();
                C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                c1438h.m400b(contentResolver);
            }
            SwipeRefreshLayout swipeRefreshLayout = this.f22079c.swipeRefreshLayout;
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
        C12238m.checkNotNullParameter(onClickListener, "onClickListener");
        return new EmptyListAdapter(C11170R.g.item_permission_storage, C11170R.f.permissions_req_btn, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(inflater, "inflater");
        this.selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        Fragment parentFragment = getParentFragment();
        ActivityResultCaller parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof InterfaceC1429b)) {
            parentFragment2 = null;
        }
        InterfaceC1429b interfaceC1429b = (InterfaceC1429b) parentFragment2;
        if (interfaceC1429b != null) {
            SelectionAggregator selectionAggregatorMo396b = interfaceC1429b.mo396b();
            SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
            C12238m.checkNotNull(selectionCoordinator);
            selectionAggregatorMo396b.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(C11170R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(C11170R.f.list);
        Context context = viewInflate.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int iWidth = (int) (DisplayUtils.getScreenSize(context).width() / 3);
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator2 = this.selectionCoordinator;
        C12238m.checkNotNull(selectionCoordinator2);
        C1438h c1438h = new C1438h(selectionCoordinator2, iWidth, iWidth);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(viewInflate.getContext(), 3));
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(c1438h);
            }
        } else {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(newPermissionsRequestAdapter(new ViewOnClickListenerC11187a(viewInflate, c1438h, this, interfaceC1429b)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(C11170R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new C11188b(viewInflate, c1438h, this, interfaceC1429b));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
        C12238m.checkNotNull(selectionCoordinator);
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
