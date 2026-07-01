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
import b.a.i.SearchInputViewBinding;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import d0.z.d.Intrinsics3;
import defpackage.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: SearchInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchInputView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final SearchInputViewBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String searchIconContentDescription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onClearClicked;

    /* JADX INFO: compiled from: SearchInputView.kt */
    public static final class a<T> implements Action1<String> {
        public final /* synthetic */ Function1 k;

        public a(Function1 function1) {
            this.k = function1;
        }

        @Override // rx.functions.Action1
        public void call(String str) {
            String str2 = str;
            Function1 function1 = this.k;
            Intrinsics3.checkNotNullExpressionValue(str2, "searchQuery");
            function1.invoke(str2);
            SearchInputView searchInputView = SearchInputView.this;
            int i = SearchInputView.j;
            searchInputView.b(str2);
        }
    }

    /* JADX INFO: compiled from: SearchInputView.kt */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ String k;

        public b(boolean z2, String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.k.length() > 0) {
                SearchInputView.this.getOnClearClicked().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.search_input_view, this);
        int i = R.id.search_clear;
        ImageView imageView = (ImageView) findViewById(R.id.search_clear);
        if (imageView != null) {
            i = R.id.search_input_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.search_input_edit_text);
            if (textInputEditText != null) {
                SearchInputViewBinding searchInputViewBinding = new SearchInputViewBinding(this, imageView, textInputEditText);
                Intrinsics3.checkNotNullExpressionValue(searchInputViewBinding, "SearchInputViewBinding.i…ater.from(context), this)");
                this.binding = searchInputViewBinding;
                this.searchIconContentDescription = "";
                this.onClearClicked = new p(1, this);
                Drawable drawable = null;
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.drawable_bg_corners_4dp, null);
                if (drawable2 != null) {
                    drawable2.setTint(ColorCompat.getThemedColor(this, R.attr.colorBackgroundTertiary));
                    drawable = drawable2;
                }
                setBackground(drawable);
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.SearchInputView);
                Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.SearchInputView)");
                String string = typedArrayObtainStyledAttributes.getString(0);
                String string2 = typedArrayObtainStyledAttributes.getString(1);
                this.searchIconContentDescription = string2 == null ? "" : string2;
                typedArrayObtainStyledAttributes.recycle();
                Intrinsics3.checkNotNullExpressionValue(textInputEditText, "searchInputEditText");
                textInputEditText.setHint(string);
                setText("");
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(Fragment fragment, Function1<? super String, Unit> onAfterTextChanged) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextWatcher.Companion companion = TextWatcher.INSTANCE;
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        companion.addBindedTextWatcher(fragment, textInputEditText, new a(onAfterTextChanged));
    }

    public final void b(String searchQuery) {
        boolean z2 = searchQuery.length() == 0;
        SearchInputViewBinding searchInputViewBinding = this.binding;
        searchInputViewBinding.f139b.setImageResource(z2 ? R.drawable.ic_search_16dp : R.drawable.ic_clear_white_24dp);
        ImageView imageView = searchInputViewBinding.f139b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "searchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted)) : ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorTextNormal)));
        ImageView imageView2 = searchInputViewBinding.f139b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "searchClear");
        imageView2.setContentDescription(z2 ? this.searchIconContentDescription : getContext().getString(R.string.reset));
        ImageView imageView3 = searchInputViewBinding.f139b;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "searchClear");
        imageView3.setImportantForAccessibility(z2 ? 2 : 0);
        searchInputViewBinding.f139b.setOnClickListener(new b(z2, searchQuery));
    }

    public final View getEditText() {
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        return textInputEditText;
    }

    public final Function0<Unit> getOnClearClicked() {
        return this.onClearClicked;
    }

    public final void setHint(CharSequence hint) {
        Intrinsics3.checkNotNullParameter(hint, "hint");
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        textInputEditText.setHint(hint);
    }

    public final void setOnClearClicked(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClearClicked = function0;
    }

    public final void setText(String searchQuery) {
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        this.binding.c.setText(searchQuery);
        b(searchQuery);
    }
}
