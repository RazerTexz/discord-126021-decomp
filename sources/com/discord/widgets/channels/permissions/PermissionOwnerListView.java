package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView extends RecyclerView {
    private final PermissionOwnerListView$Adapter adapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        PermissionOwnerListView$Adapter permissionOwnerListView$Adapter = new PermissionOwnerListView$Adapter();
        this.adapter = permissionOwnerListView$Adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(permissionOwnerListView$Adapter);
    }

    public final void setData(List<PermissionOwnerListView$Item> permissionOwners, Function1<? super PermissionOwner, Unit> onRemoveClicked) {
        m.checkNotNullParameter(permissionOwners, "permissionOwners");
        m.checkNotNullParameter(onRemoveClicked, "onRemoveClicked");
        this.adapter.setOnRemoveClicked(onRemoveClicked);
        this.adapter.setData(permissionOwners);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        PermissionOwnerListView$Adapter permissionOwnerListView$Adapter = new PermissionOwnerListView$Adapter();
        this.adapter = permissionOwnerListView$Adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(permissionOwnerListView$Adapter);
    }

    public /* synthetic */ PermissionOwnerListView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        PermissionOwnerListView$Adapter permissionOwnerListView$Adapter = new PermissionOwnerListView$Adapter();
        this.adapter = permissionOwnerListView$Adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(permissionOwnerListView$Adapter);
    }

    public /* synthetic */ PermissionOwnerListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
