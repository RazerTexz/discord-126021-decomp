package b.i.a.g.j;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener;
import java.util.Objects;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$d implements TextInputLayout$OnEditTextAttachedListener {
    public final /* synthetic */ h a;

    public h$d(h hVar) {
        this.a = hVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener
    public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
        AutoCompleteTextView autoCompleteTextViewD = h.d(textInputLayout.getEditText());
        h hVar = this.a;
        int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
        if (boxBackgroundMode == 2) {
            autoCompleteTextViewD.setDropDownBackgroundDrawable(hVar.m);
        } else if (boxBackgroundMode == 1) {
            autoCompleteTextViewD.setDropDownBackgroundDrawable(hVar.l);
        }
        h hVar2 = this.a;
        Objects.requireNonNull(hVar2);
        if (!(autoCompleteTextViewD.getKeyListener() != null)) {
            int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
            MaterialShapeDrawable boxBackground = hVar2.a.getBoxBackground();
            int color = MaterialColors.getColor(autoCompleteTextViewD, R$attr.colorControlHighlight);
            int[][] iArr = {new int[]{android.R$attr.state_pressed}, new int[0]};
            if (boxBackgroundMode2 == 2) {
                int color2 = MaterialColors.getColor(autoCompleteTextViewD, R$attr.colorSurface);
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                int iLayer = MaterialColors.layer(color, color2, 0.1f);
                materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                materialShapeDrawable.setTint(color2);
                ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                materialShapeDrawable2.setTint(-1);
                ViewCompat.setBackground(autoCompleteTextViewD, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
            } else if (boxBackgroundMode2 == 1) {
                int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                ViewCompat.setBackground(autoCompleteTextViewD, new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
            }
        }
        h hVar3 = this.a;
        Objects.requireNonNull(hVar3);
        autoCompleteTextViewD.setOnTouchListener(new j(hVar3, autoCompleteTextViewD));
        autoCompleteTextViewD.setOnFocusChangeListener(hVar3.e);
        autoCompleteTextViewD.setOnDismissListener(new k(hVar3));
        autoCompleteTextViewD.setThreshold(0);
        autoCompleteTextViewD.removeTextChangedListener(this.a.d);
        autoCompleteTextViewD.addTextChangedListener(this.a.d);
        textInputLayout.setEndIconCheckable(true);
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!(autoCompleteTextViewD.getKeyListener() != null)) {
            ViewCompat.setImportantForAccessibility(this.a.c, 2);
        }
        textInputLayout.setTextInputAccessibilityDelegate(this.a.f);
        textInputLayout.setEndIconVisible(true);
    }
}
