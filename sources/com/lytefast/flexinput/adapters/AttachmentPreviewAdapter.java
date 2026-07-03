package com.lytefast.flexinput.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import java.io.IOException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p000.ViewOnClickListenerC12252e;
import p007b.p076b.p077a.p079d.AbstractC1439i;
import p007b.p076b.p077a.p080e.C1445b;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AttachmentPreviewAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AttachmentPreviewAdapter<T extends Attachment<? extends Object>> extends RecyclerView.Adapter<AttachmentPreviewAdapter<T>.C11172b> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final SelectionAggregator<T> selectionAggregator;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean useBottomSheet;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function2<SelectionAggregator<T>, T, Unit> onAttachmentSelected;

    /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.AttachmentPreviewAdapter$a */
    /* JADX INFO: compiled from: AttachmentPreviewAdapter.kt */
    public static final class C11171a extends AbstractC12240o implements Function2<SelectionAggregator<T>, T, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C11171a f22017j = new C11171a();

        public C11171a() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Object obj, Object obj2) {
            SelectionAggregator selectionAggregator = (SelectionAggregator) obj;
            Attachment attachment = (Attachment) obj2;
            C12238m.checkNotNullParameter(selectionAggregator, "aggregator");
            C12238m.checkNotNullParameter(attachment, "attachment");
            selectionAggregator.unselectItem(attachment);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.AttachmentPreviewAdapter$b */
    /* JADX INFO: compiled from: AttachmentPreviewAdapter.kt */
    public final class C11172b extends AbstractC1439i {

        /* JADX INFO: renamed from: p */
        public final C1445b f22018p;

        /* JADX INFO: renamed from: q */
        public final Function2<SelectionAggregator<T>, T, Unit> f22019q;

        /* JADX INFO: renamed from: r */
        public final /* synthetic */ AttachmentPreviewAdapter f22020r;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public C11172b(AttachmentPreviewAdapter attachmentPreviewAdapter, C1445b c1445b, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2) {
            C12238m.checkNotNullParameter(c1445b, "binding");
            C12238m.checkNotNullParameter(function2, "onAttachmentSelected");
            this.f22020r = attachmentPreviewAdapter;
            ConstraintLayout constraintLayout = c1445b.f2189a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.f22018p = c1445b;
            this.f22019q = function2;
            GenericDraweeHierarchy hierarchy = mo401a().getHierarchy();
            Context context = mo401a().getContext();
            C12238m.checkNotNullExpressionValue(context, "imageView.context");
            hierarchy.m8680p(DrawableCompat.getThemedDrawableRes$default(context, C11170R.b.ic_flex_input_file, 0, 2, (Object) null));
        }

        @Override // p007b.p076b.p077a.p079d.AbstractC1439i
        /* JADX INFO: renamed from: a */
        public SimpleDraweeView mo401a() {
            SimpleDraweeView simpleDraweeView = this.f22018p.f2190b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentItem");
            return simpleDraweeView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter() {
        this(false, null, 0 == true ? 1 : 0, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AttachmentPreviewAdapter(boolean z2, Function2 function2, Function1 function1, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        C11171a c11171a = (i & 2) != 0 ? C11171a.f22017j : null;
        int i2 = i & 4;
        this(z2, c11171a, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.selectionAggregator.getSize();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws IOException {
        C11172b c11172b = (C11172b) viewHolder;
        C12238m.checkNotNullParameter(c11172b, "holder");
        Attachment attachment = this.selectionAggregator.get(i);
        Objects.requireNonNull(c11172b);
        C12238m.checkNotNullParameter(attachment, "item");
        if (attachment instanceof Media) {
            c11172b.mo401a().setController(null);
            c11172b.m405c((Media) attachment, null, null);
        } else {
            int dimensionPixelSize = c11172b.mo401a().getResources().getDimensionPixelSize(C11170R.d.attachment_preview_dimen);
            ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(attachment.getUri());
            imageRequestBuilderM8723b.f19616e = C1885f.f3721a;
            imageRequestBuilderM8723b.f19615d = new C1884e(dimensionPixelSize, dimensionPixelSize);
            C1733d c1733dM1037a = C1731b.m1037a();
            c1733dM1037a.f19490n = c11172b.mo401a().getController();
            c1733dM1037a.f19489m = true;
            c1733dM1037a.f19484h = imageRequestBuilderM8723b.m8724a();
            c11172b.mo401a().setController(c1733dM1037a.m8667a());
        }
        if (!c11172b.f22020r.useBottomSheet) {
            SimpleDraweeView simpleDraweeView = c11172b.f22018p.f2191c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentRemove");
            simpleDraweeView.setVisibility(8);
            c11172b.f22018p.f2190b.setOnClickListener(new ViewOnClickListenerC12252e(2, c11172b, attachment));
            return;
        }
        boolean spoiler = attachment.getSpoiler();
        View view = c11172b.f22018p.f2192d;
        C12238m.checkNotNullExpressionValue(view, "binding.attachmentSpoilerCover");
        view.setVisibility(spoiler ? 0 : 8);
        SimpleDraweeView simpleDraweeView2 = c11172b.f22018p.f2193e;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentSpoilerIcon");
        simpleDraweeView2.setVisibility(spoiler ? 0 : 8);
        c11172b.f22018p.f2191c.setOnClickListener(new ViewOnClickListenerC12252e(0, c11172b, attachment));
        c11172b.f22018p.f2190b.setOnClickListener(new ViewOnClickListenerC12252e(1, c11172b, attachment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewFindViewById;
        C12238m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11170R.g.view_attachment_preview_item, viewGroup, false);
        int i2 = C11170R.f.attachment_item;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
        if (simpleDraweeView != null) {
            i2 = C11170R.f.attachment_remove;
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView2 != null && (viewFindViewById = viewInflate.findViewById((i2 = C11170R.f.attachment_spoiler_cover))) != null) {
                i2 = C11170R.f.attachment_spoiler_icon;
                SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView3 != null) {
                    C1445b c1445b = new C1445b((ConstraintLayout) viewInflate, simpleDraweeView, simpleDraweeView2, viewFindViewById, simpleDraweeView3);
                    C12238m.checkNotNullExpressionValue(c1445b, "ViewAttachmentPreviewIte….context), parent, false)");
                    return new C11172b(this, c1445b, this.onAttachmentSelected);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        C11172b c11172b = (C11172b) viewHolder;
        C12238m.checkNotNullParameter(c11172b, "holder");
        super.onViewRecycled(c11172b);
        c11172b.m404b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter(boolean z2, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2, Function1<? super AttachmentPreviewAdapter<T>, ? extends SelectionAggregator<T>> function1) {
        SelectionAggregator<T> selectionAggregatorInvoke;
        C12238m.checkNotNullParameter(function2, "onAttachmentSelected");
        this.useBottomSheet = z2;
        this.onAttachmentSelected = function2;
        this.selectionAggregator = (function1 == null || (selectionAggregatorInvoke = function1.invoke(this)) == null) ? new SelectionAggregator<>(this, null, null, null, 14, null) : selectionAggregatorInvoke;
    }
}
