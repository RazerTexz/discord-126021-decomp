package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.b.a.a.e;
import b.b.a.b;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.adapters.FileListAdapter$a;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.m;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FilesFragment extends Fragment {
    public static final FilesFragment$Companion Companion = new FilesFragment$Companion(null);
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private FileListAdapter adapter;
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    public static final /* synthetic */ FileListAdapter access$getAdapter$p(FilesFragment filesFragment) {
        return filesFragment.adapter;
    }

    public static final /* synthetic */ SelectionCoordinator access$getSelectionCoordinator$p(FilesFragment filesFragment) {
        return filesFragment.selectionCoordinator;
    }

    public static final /* synthetic */ void access$loadDownloadFolder(FilesFragment filesFragment) {
        filesFragment.loadDownloadFolder();
    }

    public static final /* synthetic */ void access$setAdapter$p(FilesFragment filesFragment, FileListAdapter fileListAdapter) {
        filesFragment.adapter = fileListAdapter;
    }

    public static final /* synthetic */ void access$setSelectionCoordinator$p(FilesFragment filesFragment, SelectionCoordinator selectionCoordinator) {
        filesFragment.selectionCoordinator = selectionCoordinator;
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
            m.checkNotNull(swipeRefreshLayout);
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        FileListAdapter fileListAdapter = this.adapter;
        m.checkNotNull(fileListAdapter);
        m.checkNotNullExpressionValue(externalStoragePublicDirectory, "downloadFolder");
        Objects.requireNonNull(fileListAdapter);
        m.checkNotNullParameter(externalStoragePublicDirectory, "root");
        new FileListAdapter$a(fileListAdapter).execute(externalStoragePublicDirectory);
        SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefreshLayout;
        m.checkNotNull(swipeRefreshLayout2);
        swipeRefreshLayout2.setRefreshing(false);
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
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
            m.checkNotNull(selectionCoordinator);
            selectionAggregatorB.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(R$g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R$f.list);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            Context context = viewInflate.getContext();
            m.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator2 = this.selectionCoordinator;
            m.checkNotNull(selectionCoordinator2);
            FileListAdapter fileListAdapter = new FileListAdapter(contentResolver, selectionCoordinator2);
            this.adapter = fileListAdapter;
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(fileListAdapter);
            }
        } else {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(newPermissionsRequestAdapter(new FilesFragment$a(viewInflate, this, bVar)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R$f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new e(new FilesFragment$b(this)));
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
