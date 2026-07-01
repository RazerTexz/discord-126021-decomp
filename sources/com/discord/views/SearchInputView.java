package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import b.a.i.j1;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.view.text.TextWatcher$Companion;
import com.google.android.material.textfield.TextInputEditText;
import d0.z.d.m;
import defpackage.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SearchInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchInputView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final j1 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String searchIconContentDescription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onClearClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.search_input_view, this);
        int i = R$id.search_clear;
        ImageView imageView = (ImageView) findViewById(R$id.search_clear);
        if (imageView != null) {
            i = R$id.search_input_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(R$id.search_input_edit_text);
            if (textInputEditText != null) {
                j1 j1Var = new j1(this, imageView, textInputEditText);
                m.checkNotNullExpressionValue(j1Var, "SearchInputViewBinding.i…ater.from(context), this)");
                this.binding = j1Var;
                this.searchIconContentDescription = "";
                this.onClearClicked = new p(1, this);
                Drawable drawable = null;
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), 2131231109, null);
                if (drawable2 != null) {
                    drawable2.setTint(ColorCompat.getThemedColor(this, 2130968914));
                    drawable = drawable2;
                }
                setBackground(drawable);
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.SearchInputView);
                m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.SearchInputView)");
                String string = typedArrayObtainStyledAttributes.getString(0);
                String string2 = typedArrayObtainStyledAttributes.getString(1);
                this.searchIconContentDescription = string2 == null ? "" : string2;
                typedArrayObtainStyledAttributes.recycle();
                m.checkNotNullExpressionValue(textInputEditText, "searchInputEditText");
                textInputEditText.setHint(string);
                setText("");
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(Fragment fragment, Function1<? super String, Unit> onAfterTextChanged) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextWatcher$Companion textWatcher$Companion = TextWatcher.Companion;
        TextInputEditText textInputEditText = this.binding.c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        textWatcher$Companion.addBindedTextWatcher(fragment, textInputEditText, new SearchInputView$a(this, onAfterTextChanged));
    }

    public final void b(String searchQuery) {
        boolean z2 = searchQuery.length() == 0;
        j1 j1Var = this.binding;
        j1Var.f139b.setImageResource(z2 ? 2131232097 : 2131231673);
        ImageView imageView = j1Var.f139b;
        m.checkNotNullExpressionValue(imageView, "searchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), 2130969056)) : ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), 2130969057)));
        ImageView imageView2 = j1Var.f139b;
        m.checkNotNullExpressionValue(imageView2, "searchClear");
        imageView2.setContentDescription(z2 ? this.searchIconContentDescription : getContext().getString(2131894833));
        ImageView imageView3 = j1Var.f139b;
        m.checkNotNullExpressionValue(imageView3, "searchClear");
        imageView3.setImportantForAccessibility(z2 ? 2 : 0);
        j1Var.f139b.setOnClickListener(new SearchInputView$b(this, z2, searchQuery));
    }

    public final View getEditText() {
        TextInputEditText textInputEditText = this.binding.c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        return textInputEditText;
    }

    public final Function0<Unit> getOnClearClicked() {
        return this.onClearClicked;
    }

    public final void setHint(CharSequence hint) {
        m.checkNotNullParameter(hint, "hint");
        TextInputEditText textInputEditText = this.binding.c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        textInputEditText.setHint(hint);
    }

    public final void setOnClearClicked(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onClearClicked = function0;
    }

    public final void setText(String searchQuery) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        this.binding.c.setText(searchQuery);
        b(searchQuery);
    }
}
