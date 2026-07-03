package p007b.p008a.p062y;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import p007b.p008a.p025i.C0935d;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.e0 */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1328e0 extends SimpleRecyclerAdapter.ViewHolder<C1324c0> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1335i f2018a;

    /* JADX INFO: renamed from: b */
    public final DialogInterface f2019b;

    /* JADX INFO: renamed from: c */
    public final C0935d f2020c;

    /* JADX WARN: Illegal instructions before constructor call */
    public C1328e0(InterfaceC1335i interfaceC1335i, DialogInterface dialogInterface, C0935d c0935d) {
        C12238m.checkNotNullParameter(interfaceC1335i, "onSelectedListener");
        C12238m.checkNotNullParameter(dialogInterface, "dialogInterface");
        C12238m.checkNotNullParameter(c0935d, "itemBinding");
        ConstraintLayout constraintLayout = c0935d.f761a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "itemBinding.root");
        super(constraintLayout);
        this.f2018a = interfaceC1335i;
        this.f2019b = dialogInterface;
        this.f2020c = c0935d;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00da  */
    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public void bind(C1324c0 c1324c0) {
        int themedColor;
        Drawable drawable;
        C1324c0 c1324c1 = c1324c0;
        C12238m.checkNotNullParameter(c1324c1, "data");
        MaterialTextView materialTextView = this.f2020c.f764d;
        C12238m.checkNotNullExpressionValue(materialTextView, "itemBinding.selectComponentSheetItemTitle");
        C1107b.m209a(materialTextView, c1324c1.m384e());
        MaterialTextView materialTextView2 = this.f2020c.f762b;
        C12238m.checkNotNullExpressionValue(materialTextView2, "itemBinding.selectComponentSheetItemDescription");
        ViewExtensions.setTextAndVisibilityBy(materialTextView2, c1324c1.m380a());
        SimpleDraweeView simpleDraweeView = this.f2020c.f763c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.selectComponentSheetItemIcon");
        simpleDraweeView.setVisibility(c1324c1.m383d() != null || c1324c1.m381b() != null ? 0 : 8);
        String strM383d = c1324c1.m383d();
        if (strM383d != null) {
            SimpleDraweeView simpleDraweeView2 = this.f2020c.f763c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.selectComponentSheetItemIcon");
            MGImages.setImage$default(simpleDraweeView2, strM383d, C5419R.dimen.emoji_size, C5419R.dimen.emoji_size, true, null, null, 96, null);
        } else {
            Integer numM381b = c1324c1.m381b();
            if (numM381b != null) {
                this.f2020c.f763c.setImageResource(numM381b.intValue());
            }
        }
        Integer numM382c = c1324c1.m382c();
        if (numM382c != null) {
            this.f2020c.f763c.setColorFilter(numM382c.intValue());
        }
        MaterialTextView materialTextView3 = this.f2020c.f764d;
        materialTextView3.setText(c1324c1.m384e());
        Integer numM386g = c1324c1.m386g();
        if (numM386g != null) {
            themedColor = numM386g.intValue();
        } else {
            C12238m.checkNotNullExpressionValue(materialTextView3, "this");
            themedColor = ColorCompat.getThemedColor(materialTextView3, C5419R.attr.colorHeaderPrimary);
        }
        materialTextView3.setTextColor(themedColor);
        Integer numM385f = c1324c1.m385f();
        if (numM385f != null) {
            numM385f.intValue();
            Drawable drawable2 = ContextCompat.getDrawable(materialTextView3.getContext(), c1324c1.m385f().intValue());
            if (drawable2 != null) {
                MaterialTextView materialTextView4 = this.f2020c.f764d;
                C12238m.checkNotNullExpressionValue(materialTextView4, "itemBinding.selectComponentSheetItemTitle");
                DrawableCompat.setTint(drawable2, ColorCompat.getThemedColor(materialTextView4, C5419R.attr.colorHeaderPrimary));
                drawable = drawable2;
            } else {
                drawable = null;
            }
        } else {
            drawable = null;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(materialTextView3, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
        this.f2020c.f761a.setOnClickListener(new ViewOnClickListenerC1326d0(this));
    }
}
