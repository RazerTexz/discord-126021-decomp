package com.lytefast.flexinput.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import b.f.j.d.e;
import b.f.j.d.f;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lytefast.flexinput.R$d;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AttachmentPreviewAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AttachmentPreviewAdapter<T extends Attachment<? extends Object>> extends RecyclerView$Adapter<AttachmentPreviewAdapter<T>.AttachmentPreviewAdapter$b> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final SelectionAggregator<T> selectionAggregator;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean useBottomSheet;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function2<SelectionAggregator<T>, T, Unit> onAttachmentSelected;

    public AttachmentPreviewAdapter() {
        this(false, null, null, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AttachmentPreviewAdapter(boolean z2, Function2 function2, Function1 function1, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        AttachmentPreviewAdapter$a attachmentPreviewAdapter$a = (i & 2) != 0 ? AttachmentPreviewAdapter$a.j : null;
        int i2 = i & 4;
        this(z2, attachmentPreviewAdapter$a, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.selectionAggregator.getSize();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        AttachmentPreviewAdapter$b attachmentPreviewAdapter$b = (AttachmentPreviewAdapter$b) recyclerView$ViewHolder;
        m.checkNotNullParameter(attachmentPreviewAdapter$b, "holder");
        Attachment attachment = this.selectionAggregator.get(i);
        Objects.requireNonNull(attachmentPreviewAdapter$b);
        m.checkNotNullParameter(attachment, "item");
        if (attachment instanceof Media) {
            attachmentPreviewAdapter$b.a().setController(null);
            attachmentPreviewAdapter$b.c((Media) attachment, null, null);
        } else {
            int dimensionPixelSize = attachmentPreviewAdapter$b.a().getResources().getDimensionPixelSize(R$d.attachment_preview_dimen);
            ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(attachment.getUri());
            imageRequestBuilderB.e = f.a;
            imageRequestBuilderB.d = new e(dimensionPixelSize, dimensionPixelSize);
            d dVarA = b.a();
            dVarA.n = attachmentPreviewAdapter$b.a().getController();
            dVarA.m = true;
            dVarA.h = imageRequestBuilderB.a();
            attachmentPreviewAdapter$b.a().setController(dVarA.a());
        }
        if (!attachmentPreviewAdapter$b.r.useBottomSheet) {
            SimpleDraweeView simpleDraweeView = attachmentPreviewAdapter$b.p.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentRemove");
            simpleDraweeView.setVisibility(8);
            attachmentPreviewAdapter$b.p.f323b.setOnClickListener(new defpackage.e(2, attachmentPreviewAdapter$b, attachment));
            return;
        }
        boolean spoiler = attachment.getSpoiler();
        View view = attachmentPreviewAdapter$b.p.d;
        m.checkNotNullExpressionValue(view, "binding.attachmentSpoilerCover");
        view.setVisibility(spoiler ? 0 : 8);
        SimpleDraweeView simpleDraweeView2 = attachmentPreviewAdapter$b.p.e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentSpoilerIcon");
        simpleDraweeView2.setVisibility(spoiler ? 0 : 8);
        attachmentPreviewAdapter$b.p.c.setOnClickListener(new defpackage.e(0, attachmentPreviewAdapter$b, attachment));
        attachmentPreviewAdapter$b.p.f323b.setOnClickListener(new defpackage.e(1, attachmentPreviewAdapter$b, attachment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewFindViewById;
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$g.view_attachment_preview_item, viewGroup, false);
        int i2 = R$f.attachment_item;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
        if (simpleDraweeView != null) {
            i2 = R$f.attachment_remove;
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView2 != null && (viewFindViewById = viewInflate.findViewById((i2 = R$f.attachment_spoiler_cover))) != null) {
                i2 = R$f.attachment_spoiler_icon;
                SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView3 != null) {
                    b.b.a.e.b bVar = new b.b.a.e.b((ConstraintLayout) viewInflate, simpleDraweeView, simpleDraweeView2, viewFindViewById, simpleDraweeView3);
                    m.checkNotNullExpressionValue(bVar, "ViewAttachmentPreviewIte….context), parent, false)");
                    return new AttachmentPreviewAdapter$b(this, bVar, this.onAttachmentSelected);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        AttachmentPreviewAdapter$b attachmentPreviewAdapter$b = (AttachmentPreviewAdapter$b) recyclerView$ViewHolder;
        m.checkNotNullParameter(attachmentPreviewAdapter$b, "holder");
        super.onViewRecycled(attachmentPreviewAdapter$b);
        attachmentPreviewAdapter$b.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter(boolean z2, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2, Function1<? super AttachmentPreviewAdapter<T>, ? extends SelectionAggregator<T>> function1) {
        SelectionAggregator<T> selectionAggregatorInvoke;
        m.checkNotNullParameter(function2, "onAttachmentSelected");
        this.useBottomSheet = z2;
        this.onAttachmentSelected = function2;
        this.selectionAggregator = (function1 == null || (selectionAggregatorInvoke = function1.invoke(this)) == null) ? new SelectionAggregator<>(this, null, null, null, 14, null) : selectionAggregatorInvoke;
    }
}
