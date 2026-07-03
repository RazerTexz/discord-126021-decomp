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
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p000.C13002p;
import p007b.p008a.p025i.C0983j1;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: SearchInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchInputView extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19137j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0983j1 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String searchIconContentDescription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onClearClicked;

    /* JADX INFO: renamed from: com.discord.views.SearchInputView$a */
    /* JADX INFO: compiled from: SearchInputView.kt */
    public static final class C7090a<T> implements Action1<String> {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Function1 f19142k;

        public C7090a(Function1 function1) {
            this.f19142k = function1;
        }

        @Override // p658rx.functions.Action1
        public void call(String str) {
            String str2 = str;
            Function1 function1 = this.f19142k;
            C12238m.checkNotNullExpressionValue(str2, "searchQuery");
            function1.invoke(str2);
            SearchInputView searchInputView = SearchInputView.this;
            int i = SearchInputView.f19137j;
            searchInputView.m8554b(str2);
        }
    }

    /* JADX INFO: renamed from: com.discord.views.SearchInputView$b */
    /* JADX INFO: compiled from: SearchInputView.kt */
    public static final class ViewOnClickListenerC7091b implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ String f19144k;

        public ViewOnClickListenerC7091b(boolean z2, String str) {
            this.f19144k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.f19144k.length() > 0) {
                SearchInputView.this.getOnClearClicked().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.search_input_view, this);
        int i = C5419R.id.search_clear;
        ImageView imageView = (ImageView) findViewById(C5419R.id.search_clear);
        if (imageView != null) {
            i = C5419R.id.search_input_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(C5419R.id.search_input_edit_text);
            if (textInputEditText != null) {
                C0983j1 c0983j1 = new C0983j1(this, imageView, textInputEditText);
                C12238m.checkNotNullExpressionValue(c0983j1, "SearchInputViewBinding.i…ater.from(context), this)");
                this.binding = c0983j1;
                this.searchIconContentDescription = "";
                this.onClearClicked = new C13002p(1, this);
                Drawable drawable = null;
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), C5419R.drawable.drawable_bg_corners_4dp, null);
                if (drawable2 != null) {
                    drawable2.setTint(ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundTertiary));
                    drawable = drawable2;
                }
                setBackground(drawable);
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.SearchInputView);
                C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.SearchInputView)");
                String string = typedArrayObtainStyledAttributes.getString(0);
                String string2 = typedArrayObtainStyledAttributes.getString(1);
                this.searchIconContentDescription = string2 == null ? "" : string2;
                typedArrayObtainStyledAttributes.recycle();
                C12238m.checkNotNullExpressionValue(textInputEditText, "searchInputEditText");
                textInputEditText.setHint(string);
                setText("");
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8553a(Fragment fragment, Function1<? super String, Unit> onAfterTextChanged) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextWatcher.Companion companion = TextWatcher.INSTANCE;
        TextInputEditText textInputEditText = this.binding.f971c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        companion.addBindedTextWatcher(fragment, textInputEditText, new C7090a(onAfterTextChanged));
    }

    /* JADX INFO: renamed from: b */
    public final void m8554b(String searchQuery) {
        boolean z2 = searchQuery.length() == 0;
        C0983j1 c0983j1 = this.binding;
        c0983j1.f970b.setImageResource(z2 ? C5419R.drawable.ic_search_16dp : C5419R.drawable.ic_clear_white_24dp);
        ImageView imageView = c0983j1.f970b;
        C12238m.checkNotNullExpressionValue(imageView, "searchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextMuted)) : ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextNormal)));
        ImageView imageView2 = c0983j1.f970b;
        C12238m.checkNotNullExpressionValue(imageView2, "searchClear");
        imageView2.setContentDescription(z2 ? this.searchIconContentDescription : getContext().getString(C5419R.string.reset));
        ImageView imageView3 = c0983j1.f970b;
        C12238m.checkNotNullExpressionValue(imageView3, "searchClear");
        imageView3.setImportantForAccessibility(z2 ? 2 : 0);
        c0983j1.f970b.setOnClickListener(new ViewOnClickListenerC7091b(z2, searchQuery));
    }

    public final View getEditText() {
        TextInputEditText textInputEditText = this.binding.f971c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        return textInputEditText;
    }

    public final Function0<Unit> getOnClearClicked() {
        return this.onClearClicked;
    }

    public final void setHint(CharSequence hint) {
        C12238m.checkNotNullParameter(hint, "hint");
        TextInputEditText textInputEditText = this.binding.f971c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        textInputEditText.setHint(hint);
    }

    public final void setOnClearClicked(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onClearClicked = function0;
    }

    public final void setText(String searchQuery) {
        C12238m.checkNotNullParameter(searchQuery, "searchQuery");
        this.binding.f971c.setText(searchQuery);
        m8554b(searchQuery);
    }
}
