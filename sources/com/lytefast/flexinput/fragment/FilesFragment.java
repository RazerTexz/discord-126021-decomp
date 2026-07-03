package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.io.File;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p076b.p077a.InterfaceC1429b;
import p007b.p076b.p077a.p078a.C1417e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FilesFragment extends Fragment {
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private FileListAdapter adapter;
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FilesFragment$a */
    /* JADX INFO: compiled from: FilesFragment.kt */
    public static final class ViewOnClickListenerC11179a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ View f22051j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ FilesFragment f22052k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ InterfaceC1429b f22053l;

        /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FilesFragment$a$a */
        /* JADX INFO: compiled from: FilesFragment.kt */
        public static final class a extends AbstractC12240o implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ContentResolver contentResolver;
                Context context = ViewOnClickListenerC11179a.this.f22051j.getContext();
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    FilesFragment filesFragment = ViewOnClickListenerC11179a.this.f22052k;
                    SelectionCoordinator selectionCoordinator = filesFragment.selectionCoordinator;
                    C12238m.checkNotNull(selectionCoordinator);
                    filesFragment.adapter = new FileListAdapter(contentResolver, selectionCoordinator);
                    RecyclerView recyclerView = ViewOnClickListenerC11179a.this.f22052k.getRecyclerView();
                    if (recyclerView != null) {
                        recyclerView.setAdapter(ViewOnClickListenerC11179a.this.f22052k.adapter);
                    }
                    ViewOnClickListenerC11179a.this.f22052k.loadDownloadFolder();
                }
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC11179a(View view, FilesFragment filesFragment, InterfaceC1429b interfaceC1429b) {
            this.f22051j = view;
            this.f22052k = filesFragment;
            this.f22053l = interfaceC1429b;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            InterfaceC1429b interfaceC1429b = this.f22053l;
            if (interfaceC1429b != null) {
                interfaceC1429b.requestMediaPermissions(new a());
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FilesFragment$b */
    /* JADX INFO: compiled from: FilesFragment.kt */
    public static final /* synthetic */ class C11180b extends C12236k implements Function0<Unit> {
        public C11180b(FilesFragment filesFragment) {
            super(0, filesFragment, FilesFragment.class, "loadDownloadFolder", "loadDownloadFolder()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((FilesFragment) this.receiver).loadDownloadFolder();
            return Unit.f27425a;
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

    private final void loadDownloadFolder() {
        if (this.adapter == null) {
            SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
            C12238m.checkNotNull(swipeRefreshLayout);
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        FileListAdapter fileListAdapter = this.adapter;
        C12238m.checkNotNull(fileListAdapter);
        C12238m.checkNotNullExpressionValue(externalStoragePublicDirectory, "downloadFolder");
        Objects.requireNonNull(fileListAdapter);
        C12238m.checkNotNullParameter(externalStoragePublicDirectory, "root");
        new FileListAdapter.AsyncTaskC11173a(fileListAdapter).execute(externalStoragePublicDirectory);
        SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefreshLayout;
        C12238m.checkNotNull(swipeRefreshLayout2);
        swipeRefreshLayout2.setRefreshing(false);
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
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
            C12238m.checkNotNull(selectionCoordinator);
            selectionAggregatorMo396b.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(C11170R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(C11170R.f.list);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            Context context = viewInflate.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator2 = this.selectionCoordinator;
            C12238m.checkNotNull(selectionCoordinator2);
            FileListAdapter fileListAdapter = new FileListAdapter(contentResolver, selectionCoordinator2);
            this.adapter = fileListAdapter;
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(fileListAdapter);
            }
        } else {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(newPermissionsRequestAdapter(new ViewOnClickListenerC11179a(viewInflate, this, interfaceC1429b)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(C11170R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new C1417e(new C11180b(this)));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
        if (selectionCoordinator != null) {
            selectionCoordinator.itemSelectionListener.unregister();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        loadDownloadFolder();
    }

    public final void setRecyclerView$flexinput_release(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
