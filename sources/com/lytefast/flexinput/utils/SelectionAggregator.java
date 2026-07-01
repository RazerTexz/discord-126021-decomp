package com.lytefast.flexinput.utils;

import android.os.Parcelable;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectionAggregator.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionAggregator<T extends Attachment<? extends Object>> {
    private static final String TAG;
    private final AttachmentPreviewAdapter<T> adapter;
    private final ArrayList<T> attachments;
    private final ArrayList<SelectionCoordinator<T, ?>> childSelectionCoordinators;
    private ArrayList<SelectionCoordinator.ItemSelectionListener<T>> itemSelectionListeners;

    /* JADX INFO: compiled from: SelectionAggregator.kt */
    public static final class a implements SelectionCoordinator.ItemSelectionListener<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectionCoordinator f3169b;

        public a(SelectionCoordinator selectionCoordinator) {
            this.f3169b = selectionCoordinator;
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemSelected(Object obj) {
            Attachment attachment = (Attachment) obj;
            Intrinsics3.checkNotNullParameter(attachment, "item");
            SelectionAggregator.this.addItem(attachment);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemUnselected(Object obj) {
            Attachment attachment = (Attachment) obj;
            Intrinsics3.checkNotNullParameter(attachment, "item");
            SelectionAggregator.this.removeItem(attachment);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void unregister() {
            SelectionAggregator.this.getChildSelectionCoordinators().remove(this.f3169b);
        }
    }

    static {
        String canonicalName = SelectionAggregator.class.getCanonicalName();
        Intrinsics3.checkNotNull(canonicalName);
        TAG = canonicalName;
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
        this(attachmentPreviewAdapter, null, null, null, 14, null);
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList) {
        this(attachmentPreviewAdapter, arrayList, null, null, 12, null);
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList, ArrayList<SelectionCoordinator<T, ?>> arrayList2) {
        this(attachmentPreviewAdapter, arrayList, arrayList2, null, 8, null);
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList, ArrayList<SelectionCoordinator<T, ?>> arrayList2, ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList3) {
        Intrinsics3.checkNotNullParameter(attachmentPreviewAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(arrayList, "attachments");
        Intrinsics3.checkNotNullParameter(arrayList2, "childSelectionCoordinators");
        Intrinsics3.checkNotNullParameter(arrayList3, "itemSelectionListeners");
        this.adapter = attachmentPreviewAdapter;
        this.attachments = arrayList;
        this.childSelectionCoordinators = arrayList2;
        this.itemSelectionListeners = arrayList3;
    }

    private final void addItem(T item) {
        if (this.attachments.contains(item)) {
            return;
        }
        this.attachments.add(item);
        this.adapter.notifyItemInserted(this.attachments.size() - 1);
        Iterator<T> it = this.itemSelectionListeners.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator.ItemSelectionListener) it.next()).onItemSelected(item);
        }
    }

    private final boolean removeItem(T item) {
        int iIndexOf = this.attachments.indexOf(item);
        boolean zRemove = this.attachments.remove(item);
        if (zRemove) {
            this.adapter.notifyItemRemoved(iIndexOf);
        }
        Iterator<T> it = this.itemSelectionListeners.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator.ItemSelectionListener) it.next()).onItemUnselected(item);
        }
        return zRemove;
    }

    public final SelectionAggregator<T> addItemSelectionListener(SelectionCoordinator.ItemSelectionListener<? super T> itemSelectionListener) {
        Intrinsics3.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
        if (!this.itemSelectionListeners.contains(itemSelectionListener)) {
            this.itemSelectionListeners.add(itemSelectionListener);
        }
        return this;
    }

    public final void clear() {
        this.attachments.clear();
        Iterator<T> it = this.childSelectionCoordinators.iterator();
        while (it.hasNext()) {
            SelectionCoordinator selectionCoordinator = (SelectionCoordinator) it.next();
            Objects.requireNonNull(selectionCoordinator);
            ArrayList<Integer> arrayList = new ArrayList(selectionCoordinator.selectedItemPositionMap.values());
            selectionCoordinator.selectedItemPositionMap.clear();
            RecyclerView.Adapter<?> adapter = selectionCoordinator.adapter;
            if (adapter != null) {
                for (Integer num : arrayList) {
                    Intrinsics3.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_POSITION);
                    adapter.notifyItemChanged(num.intValue());
                }
            }
        }
    }

    public final T get(int position) {
        T t = this.attachments.get(position);
        Intrinsics3.checkNotNullExpressionValue(t, "attachments[position]");
        return t;
    }

    public final AttachmentPreviewAdapter<T> getAdapter() {
        return this.adapter;
    }

    public final ArrayList<T> getAttachments() {
        return this.attachments;
    }

    public final ArrayList<SelectionCoordinator<T, ?>> getChildSelectionCoordinators() {
        return this.childSelectionCoordinators;
    }

    public final ArrayList<SelectionCoordinator.ItemSelectionListener<T>> getItemSelectionListeners() {
        return this.itemSelectionListeners;
    }

    public final int getSize() {
        return this.attachments.size();
    }

    public final SelectionAggregator<T> initFrom(SelectionAggregator<T> old) {
        if (old != null) {
            this.attachments.addAll(old.attachments);
            for (SelectionCoordinator<T, ?> selectionCoordinator : old.childSelectionCoordinators) {
                Intrinsics3.checkNotNullExpressionValue(selectionCoordinator, "coordinator");
                registerSelectionCoordinatorInternal(selectionCoordinator);
            }
            this.itemSelectionListeners.addAll(old.itemSelectionListeners);
        }
        return this;
    }

    public final void registerSelectionCoordinator(SelectionCoordinator<T, ?> selectionCoordinator) {
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        registerSelectionCoordinatorInternal(selectionCoordinator);
        try {
            selectionCoordinator.b(this.attachments);
        } catch (SelectionCoordinator.RestorationException e) {
            Log.d(TAG, "selections could not be synced", e);
        }
    }

    public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        a aVar = new a(selectionCoordinator);
        Objects.requireNonNull(selectionCoordinator);
        Intrinsics3.checkNotNullParameter(aVar, "<set-?>");
        selectionCoordinator.itemSelectionListener = aVar;
        this.childSelectionCoordinators.add(selectionCoordinator);
    }

    public final void removeItemSelectionListener(SelectionCoordinator.ItemSelectionListener<?> itemSelectionListener) {
        Intrinsics3.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
        ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList = this.itemSelectionListeners;
        Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        TypeIntrinsics.asMutableCollection(arrayList).remove(itemSelectionListener);
    }

    public final void setItemSelectionListeners(ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList) {
        Intrinsics3.checkNotNullParameter(arrayList, "<set-?>");
        this.itemSelectionListeners = arrayList;
    }

    public final boolean toggleItemInternal(T item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        boolean zRemoveItem = removeItem(item);
        if (!zRemoveItem) {
            addItem(item);
        }
        return zRemoveItem;
    }

    public final void unselectItem(T item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Iterator<T> it = this.childSelectionCoordinators.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator) it.next()).d(item);
        }
        removeItem(item);
    }

    public /* synthetic */ SelectionAggregator(AttachmentPreviewAdapter attachmentPreviewAdapter, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attachmentPreviewAdapter, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList(4) : arrayList2, (i & 8) != 0 ? new ArrayList(4) : arrayList3);
    }

    public final SelectionAggregator<T> initFrom(ArrayList<? super Parcelable> savedAttachments) {
        Intrinsics3.checkNotNullParameter(savedAttachments, "savedAttachments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : savedAttachments) {
            if (!(obj instanceof Attachment)) {
                obj = null;
            }
            Attachment attachment = (Attachment) obj;
            if (attachment != null) {
                arrayList.add(attachment);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            toggleItemInternal((Attachment) it.next());
        }
        return this;
    }
}
