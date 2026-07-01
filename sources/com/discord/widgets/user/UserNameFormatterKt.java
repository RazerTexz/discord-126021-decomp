package com.discord.widgets.user;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.AttrRes;
import androidx.annotation.IntegerRes;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.user.UserUtils;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: UserNameFormatter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserNameFormatterKt {
    public static final SpannableStringBuilder getSpannableForUserNameWithDiscrim(User user, String str, Context context, @AttrRes int i, @AttrRes int i2, @IntegerRes int i3, @AttrRes int i4, @AttrRes int i5, @IntegerRes int i6) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(context, "context");
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(context, i2);
        List listListOf = n.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context, i)), themedFont != null ? new TypefaceSpanCompat(themedFont) : null, new AbsoluteSizeSpan(context.getResources().getInteger(i3), true));
        if (str != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), 0, str.length(), 33);
            }
            return spannableStringBuilder;
        }
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(userNameWithDiscriminator$default);
        Iterator it2 = listListOf.iterator();
        while (it2.hasNext()) {
            spannableStringBuilder2.setSpan(it2.next(), 0, user.getUsername().length(), 33);
        }
        Typeface themedFont2 = FontUtils.INSTANCE.getThemedFont(context, i5);
        Iterator it3 = n.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context, i4)), themedFont2 != null ? new TypefaceSpanCompat(themedFont2) : null, new AbsoluteSizeSpan(context.getResources().getInteger(i6), true)).iterator();
        while (it3.hasNext()) {
            spannableStringBuilder2.setSpan(it3.next(), user.getUsername().length(), userNameWithDiscriminator$default.length(), 33);
        }
        return spannableStringBuilder2;
    }
}
