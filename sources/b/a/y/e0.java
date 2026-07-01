package b.a.y;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends SimpleRecyclerAdapter$ViewHolder<c0> {
    public final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f310b;
    public final b.a.i.d c;

    /* JADX WARN: Illegal instructions before constructor call */
    public e0(i iVar, DialogInterface dialogInterface, b.a.i.d dVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "onSelectedListener");
        d0.z.d.m.checkNotNullParameter(dialogInterface, "dialogInterface");
        d0.z.d.m.checkNotNullParameter(dVar, "itemBinding");
        ConstraintLayout constraintLayout = dVar.a;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "itemBinding.root");
        super(constraintLayout);
        this.a = iVar;
        this.f310b = dialogInterface;
        this.c = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00da  */
    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public void bind(c0 c0Var) {
        int themedColor;
        Drawable drawable;
        c0 c0Var2 = c0Var;
        d0.z.d.m.checkNotNullParameter(c0Var2, "data");
        MaterialTextView materialTextView = this.c.d;
        d0.z.d.m.checkNotNullExpressionValue(materialTextView, "itemBinding.selectComponentSheetItemTitle");
        b.a.k.b.a(materialTextView, c0Var2.e());
        MaterialTextView materialTextView2 = this.c.f95b;
        d0.z.d.m.checkNotNullExpressionValue(materialTextView2, "itemBinding.selectComponentSheetItemDescription");
        ViewExtensions.setTextAndVisibilityBy(materialTextView2, c0Var2.a());
        SimpleDraweeView simpleDraweeView = this.c.c;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.selectComponentSheetItemIcon");
        simpleDraweeView.setVisibility(c0Var2.d() != null || c0Var2.b() != null ? 0 : 8);
        String strD = c0Var2.d();
        if (strD != null) {
            SimpleDraweeView simpleDraweeView2 = this.c.c;
            d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.selectComponentSheetItemIcon");
            MGImages.setImage$default(simpleDraweeView2, strD, 2131165401, 2131165401, true, null, null, 96, null);
        } else {
            Integer numB = c0Var2.b();
            if (numB != null) {
                this.c.c.setImageResource(numB.intValue());
            }
        }
        Integer numC = c0Var2.c();
        if (numC != null) {
            this.c.c.setColorFilter(numC.intValue());
        }
        MaterialTextView materialTextView3 = this.c.d;
        materialTextView3.setText(c0Var2.e());
        Integer numG = c0Var2.g();
        if (numG != null) {
            themedColor = numG.intValue();
        } else {
            d0.z.d.m.checkNotNullExpressionValue(materialTextView3, "this");
            themedColor = ColorCompat.getThemedColor(materialTextView3, 2130968989);
        }
        materialTextView3.setTextColor(themedColor);
        Integer numF = c0Var2.f();
        if (numF != null) {
            numF.intValue();
            Drawable drawable2 = ContextCompat.getDrawable(materialTextView3.getContext(), c0Var2.f().intValue());
            if (drawable2 != null) {
                MaterialTextView materialTextView4 = this.c.d;
                d0.z.d.m.checkNotNullExpressionValue(materialTextView4, "itemBinding.selectComponentSheetItemTitle");
                DrawableCompat.setTint(drawable2, ColorCompat.getThemedColor(materialTextView4, 2130968989));
                drawable = drawable2;
            } else {
                drawable = null;
            }
        } else {
            drawable = null;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(materialTextView3, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
        this.c.a.setOnClickListener(new d0(this));
    }
}
