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
import b.b.a.FlexInputCoordinator;
import b.b.a.a.FilesFragment2;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FilesFragment extends Fragment {
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private FileListAdapter adapter;
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: compiled from: FilesFragment.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View j;
        public final /* synthetic */ FilesFragment k;
        public final /* synthetic */ FlexInputCoordinator l;

        /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FilesFragment$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FilesFragment.kt */
        public static final class C0369a extends Lambda implements Function0<Unit> {
            public C0369a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ContentResolver contentResolver;
                Context context = a.this.j.getContext();
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    FilesFragment filesFragment = a.this.k;
                    SelectionCoordinator selectionCoordinator = filesFragment.selectionCoordinator;
                    Intrinsics3.checkNotNull(selectionCoordinator);
                    filesFragment.adapter = new FileListAdapter(contentResolver, selectionCoordinator);
                    RecyclerView recyclerView = a.this.k.getRecyclerView();
                    if (recyclerView != null) {
                        recyclerView.setAdapter(a.this.k.adapter);
                    }
                    a.this.k.loadDownloadFolder();
                }
                return Unit.a;
            }
        }

        public a(View view, FilesFragment filesFragment, FlexInputCoordinator flexInputCoordinator) {
            this.j = view;
            this.k = filesFragment;
            this.l = flexInputCoordinator;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FlexInputCoordinator flexInputCoordinator = this.l;
            if (flexInputCoordinator != null) {
                flexInputCoordinator.requestMediaPermissions(new C0369a());
            }
        }
    }

    /* JADX INFO: compiled from: FilesFragment.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(FilesFragment filesFragment) {
            super(0, filesFragment, FilesFragment.class, "loadDownloadFolder", "loadDownloadFolder()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((FilesFragment) this.receiver).loadDownloadFolder();
            return Unit.a;
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
            Intrinsics3.checkNotNull(swipeRefreshLayout);
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        FileListAdapter fileListAdapter = this.adapter;
        Intrinsics3.checkNotNull(fileListAdapter);
        Intrinsics3.checkNotNullExpressionValue(externalStoragePublicDirectory, "downloadFolder");
        Objects.requireNonNull(fileListAdapter);
        Intrinsics3.checkNotNullParameter(externalStoragePublicDirectory, "root");
        new FileListAdapter.a(fileListAdapter).execute(externalStoragePublicDirectory);
        SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefreshLayout;
        Intrinsics3.checkNotNull(swipeRefreshLayout2);
        swipeRefreshLayout2.setRefreshing(false);
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
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator);
            selectionAggregatorB.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.f.list);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            Context context = viewInflate.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator2 = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator2);
            FileListAdapter fileListAdapter = new FileListAdapter(contentResolver, selectionCoordinator2);
            this.adapter = fileListAdapter;
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(fileListAdapter);
            }
        } else {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(newPermissionsRequestAdapter(new a(viewInflate, this, flexInputCoordinator)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new FilesFragment2(new b(this)));
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
