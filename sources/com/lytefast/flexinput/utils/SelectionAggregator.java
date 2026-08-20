package com.lytefast.flexinput.utils;

import android.os.Parcelable;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectionAggregator.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionAggregator<T extends Attachment<? extends Object>> {
    private static final String TAG;
    private final AttachmentPreviewAdapter<T> adapter;
    private final ArrayList<T> attachments;
    private final ArrayList<SelectionCoordinator<T, ?>> childSelectionCoordinators;
    private ArrayList<SelectionCoordinator.ItemSelectionListener<T>> itemSelectionListeners;

    /* JADX INFO: renamed from: com.lytefast.flexinput.utils.SelectionAggregator$a */
    /* JADX INFO: compiled from: SelectionAggregator.kt */
    public static final class C11191a implements SelectionCoordinator.ItemSelectionListener<T> {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ SelectionCoordinator f22085b;

        public C11191a(SelectionCoordinator selectionCoordinator) {
            this.f22085b = selectionCoordinator;
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemSelected(Object obj) {
            Attachment attachment = (Attachment) obj;
            C12238m.checkNotNullParameter(attachment, "item");
            SelectionAggregator.this.addItem(attachment);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemUnselected(Object obj) {
            Attachment attachment = (Attachment) obj;
            C12238m.checkNotNullParameter(attachment, "item");
            SelectionAggregator.this.removeItem(attachment);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void unregister() {
            SelectionAggregator.this.getChildSelectionCoordinators().remove(this.f22085b);
        }
    }

    static {
        String canonicalName = SelectionAggregator.class.getCanonicalName();
        C12238m.checkNotNull(canonicalName);
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
        C12238m.checkNotNullParameter(attachmentPreviewAdapter, "adapter");
        C12238m.checkNotNullParameter(arrayList, "attachments");
        C12238m.checkNotNullParameter(arrayList2, "childSelectionCoordinators");
        C12238m.checkNotNullParameter(arrayList3, "itemSelectionListeners");
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
        C12238m.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
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
                    C12238m.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_POSITION);
                    adapter.notifyItemChanged(num.intValue());
                }
            }
        }
    }

    public final T get(int position) {
        T t = this.attachments.get(position);
        C12238m.checkNotNullExpressionValue(t, "attachments[position]");
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
                C12238m.checkNotNullExpressionValue(selectionCoordinator, "coordinator");
                registerSelectionCoordinatorInternal(selectionCoordinator);
            }
            this.itemSelectionListeners.addAll(old.itemSelectionListeners);
        }
        return this;
    }

    public final void registerSelectionCoordinator(SelectionCoordinator<T, ?> selectionCoordinator) {
        C12238m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        registerSelectionCoordinatorInternal(selectionCoordinator);
        try {
            selectionCoordinator.m9299b(this.attachments);
        } catch (SelectionCoordinator.RestorationException e) {
            Log.d(TAG, "selections could not be synced", e);
        }
    }

    public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
        C12238m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        C11191a c11191a = new C11191a(selectionCoordinator);
        Objects.requireNonNull(selectionCoordinator);
        C12238m.checkNotNullParameter(c11191a, "<set-?>");
        selectionCoordinator.itemSelectionListener = c11191a;
        this.childSelectionCoordinators.add(selectionCoordinator);
    }

    public final void removeItemSelectionListener(SelectionCoordinator.ItemSelectionListener<?> itemSelectionListener) {
        C12238m.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
        ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList = this.itemSelectionListeners;
        Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        C12224e0.asMutableCollection(arrayList).remove(itemSelectionListener);
    }

    public final void setItemSelectionListeners(ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList) {
        C12238m.checkNotNullParameter(arrayList, "<set-?>");
        this.itemSelectionListeners = arrayList;
    }

    public final boolean toggleItemInternal(T item) {
        C12238m.checkNotNullParameter(item, "item");
        boolean zRemoveItem = removeItem(item);
        if (!zRemoveItem) {
            addItem(item);
        }
        return zRemoveItem;
    }

    public final void unselectItem(T item) {
        C12238m.checkNotNullParameter(item, "item");
        Iterator<T> it = this.childSelectionCoordinators.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator) it.next()).m9301d(item);
        }
        removeItem(item);
    }

    public /* synthetic */ SelectionAggregator(AttachmentPreviewAdapter attachmentPreviewAdapter, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attachmentPreviewAdapter, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList(4) : arrayList2, (i & 8) != 0 ? new ArrayList(4) : arrayList3);
    }

    public final SelectionAggregator<T> initFrom(ArrayList<? super Parcelable> savedAttachments) {
        C12238m.checkNotNullParameter(savedAttachments, "savedAttachments");
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
