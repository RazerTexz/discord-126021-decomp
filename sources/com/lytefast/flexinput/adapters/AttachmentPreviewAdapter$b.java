package com.lytefast.flexinput.adapters;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.b.a.d.i;
import b.b.a.e.b;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R$b;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AttachmentPreviewAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AttachmentPreviewAdapter$b extends i {
    public final b p;
    public final Function2<SelectionAggregator<T>, T, Unit> q;
    public final /* synthetic */ AttachmentPreviewAdapter r;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter$b(AttachmentPreviewAdapter attachmentPreviewAdapter, b bVar, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2) {
        m.checkNotNullParameter(bVar, "binding");
        m.checkNotNullParameter(function2, "onAttachmentSelected");
        this.r = attachmentPreviewAdapter;
        ConstraintLayout constraintLayout = bVar.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout);
        this.p = bVar;
        this.q = function2;
        GenericDraweeHierarchy hierarchy = a().getHierarchy();
        Context context = a().getContext();
        m.checkNotNullExpressionValue(context, "imageView.context");
        hierarchy.p(DrawableCompat.getThemedDrawableRes$default(context, R$b.ic_flex_input_file, 0, 2, (Object) null));
    }

    @Override // b.b.a.d.i
    public SimpleDraweeView a() {
        SimpleDraweeView simpleDraweeView = this.p.f323b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentItem");
        return simpleDraweeView;
    }
}
