package com.lytefast.flexinput.utils;

import android.os.Parcelable;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectionAggregator.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionAggregator<T extends Attachment<? extends Object>> {
    public static final SelectionAggregator$Companion Companion = new SelectionAggregator$Companion(null);
    private static final String TAG;
    private final AttachmentPreviewAdapter<T> adapter;
    private final ArrayList<T> attachments;
    private final ArrayList<SelectionCoordinator<T, ?>> childSelectionCoordinators;
    private ArrayList<SelectionCoordinator$ItemSelectionListener<T>> itemSelectionListeners;

    static {
        String canonicalName = SelectionAggregator.class.getCanonicalName();
        m.checkNotNull(canonicalName);
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

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList, ArrayList<SelectionCoordinator<T, ?>> arrayList2, ArrayList<SelectionCoordinator$ItemSelectionListener<T>> arrayList3) {
        m.checkNotNullParameter(attachmentPreviewAdapter, "adapter");
        m.checkNotNullParameter(arrayList, "attachments");
        m.checkNotNullParameter(arrayList2, "childSelectionCoordinators");
        m.checkNotNullParameter(arrayList3, "itemSelectionListeners");
        this.adapter = attachmentPreviewAdapter;
        this.attachments = arrayList;
        this.childSelectionCoordinators = arrayList2;
        this.itemSelectionListeners = arrayList3;
    }

    public static final /* synthetic */ void access$addItem(SelectionAggregator selectionAggregator, Attachment attachment) {
        selectionAggregator.addItem(attachment);
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ boolean access$removeItem(SelectionAggregator selectionAggregator, Attachment attachment) {
        return selectionAggregator.removeItem(attachment);
    }

    private final void addItem(T item) {
        if (this.attachments.contains(item)) {
            return;
        }
        this.attachments.add(item);
        this.adapter.notifyItemInserted(this.attachments.size() - 1);
        Iterator<T> it = this.itemSelectionListeners.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator$ItemSelectionListener) it.next()).onItemSelected(item);
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
            ((SelectionCoordinator$ItemSelectionListener) it.next()).onItemUnselected(item);
        }
        return zRemove;
    }

    public final SelectionAggregator<T> addItemSelectionListener(SelectionCoordinator$ItemSelectionListener<? super T> itemSelectionListener) {
        m.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
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
            RecyclerView$Adapter<?> recyclerView$Adapter = selectionCoordinator.adapter;
            if (recyclerView$Adapter != null) {
                for (Integer num : arrayList) {
                    m.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_POSITION);
                    recyclerView$Adapter.notifyItemChanged(num.intValue());
                }
            }
        }
    }

    public final T get(int position) {
        T t = this.attachments.get(position);
        m.checkNotNullExpressionValue(t, "attachments[position]");
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

    public final ArrayList<SelectionCoordinator$ItemSelectionListener<T>> getItemSelectionListeners() {
        return this.itemSelectionListeners;
    }

    public final int getSize() {
        return this.attachments.size();
    }

    public final SelectionAggregator<T> initFrom(SelectionAggregator<T> old) {
        if (old != null) {
            this.attachments.addAll(old.attachments);
            for (SelectionCoordinator<T, ?> selectionCoordinator : old.childSelectionCoordinators) {
                m.checkNotNullExpressionValue(selectionCoordinator, "coordinator");
                registerSelectionCoordinatorInternal(selectionCoordinator);
            }
            this.itemSelectionListeners.addAll(old.itemSelectionListeners);
        }
        return this;
    }

    public final void registerSelectionCoordinator(SelectionCoordinator<T, ?> selectionCoordinator) {
        m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        registerSelectionCoordinatorInternal(selectionCoordinator);
        try {
            selectionCoordinator.b(this.attachments);
        } catch (SelectionCoordinator$RestorationException e) {
            Log.d(TAG, "selections could not be synced", e);
        }
    }

    public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
        m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        SelectionAggregator$a selectionAggregator$a = new SelectionAggregator$a(this, selectionCoordinator);
        Objects.requireNonNull(selectionCoordinator);
        m.checkNotNullParameter(selectionAggregator$a, "<set-?>");
        selectionCoordinator.itemSelectionListener = selectionAggregator$a;
        this.childSelectionCoordinators.add(selectionCoordinator);
    }

    public final void removeItemSelectionListener(SelectionCoordinator$ItemSelectionListener<?> itemSelectionListener) {
        m.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
        ArrayList<SelectionCoordinator$ItemSelectionListener<T>> arrayList = this.itemSelectionListeners;
        Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        e0.asMutableCollection(arrayList).remove(itemSelectionListener);
    }

    public final void setItemSelectionListeners(ArrayList<SelectionCoordinator$ItemSelectionListener<T>> arrayList) {
        m.checkNotNullParameter(arrayList, "<set-?>");
        this.itemSelectionListeners = arrayList;
    }

    public final boolean toggleItemInternal(T item) {
        m.checkNotNullParameter(item, "item");
        boolean zRemoveItem = removeItem(item);
        if (!zRemoveItem) {
            addItem(item);
        }
        return zRemoveItem;
    }

    public final void unselectItem(T item) {
        m.checkNotNullParameter(item, "item");
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
        m.checkNotNullParameter(savedAttachments, "savedAttachments");
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
