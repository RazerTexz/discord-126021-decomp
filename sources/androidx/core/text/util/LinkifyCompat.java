package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build$VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify$MatchFilter;
import android.text.util.Linkify$TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import b.d.b.a.a;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class LinkifyCompat {
    private static final String[] EMPTY_STRING = new String[0];
    private static final Comparator<LinkifyCompat$LinkSpec> COMPARATOR = new LinkifyCompat$1();

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@NonNull TextView textView) {
        if ((textView.getMovementMethod() instanceof LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList<LinkifyCompat$LinkSpec> arrayList = new ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        for (LinkifyCompat$LinkSpec linkifyCompat$LinkSpec : arrayList) {
            if (linkifyCompat$LinkSpec.frameworkAddedSpan == null) {
                applyLink(linkifyCompat$LinkSpec.url, linkifyCompat$LinkSpec.start, linkifyCompat$LinkSpec.end, spannable);
            }
        }
        return true;
    }

    private static void applyLink(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static String findAddress(String str) {
        return Build$VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : FindAddress.findAddress(str);
    }

    private static void gatherLinks(ArrayList<LinkifyCompat$LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify$MatchFilter linkify$MatchFilter, Linkify$TransformFilter linkify$TransformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (linkify$MatchFilter == null || linkify$MatchFilter.acceptMatch(spannable, iStart, iEnd)) {
                LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
                linkifyCompat$LinkSpec.url = makeUrl(matcher.group(0), strArr, matcher, linkify$TransformFilter);
                linkifyCompat$LinkSpec.start = iStart;
                linkifyCompat$LinkSpec.end = iEnd;
                arrayList.add(linkifyCompat$LinkSpec);
            }
        }
    }

    private static void gatherMapLinks(ArrayList<LinkifyCompat$LinkSpec> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String strFindAddress = findAddress(string);
                if (strFindAddress != null && (iIndexOf = string.indexOf(strFindAddress)) >= 0) {
                    LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
                    int length = strFindAddress.length() + iIndexOf;
                    linkifyCompat$LinkSpec.start = iIndexOf + i;
                    i += length;
                    linkifyCompat$LinkSpec.end = i;
                    string = string.substring(length);
                    try {
                        linkifyCompat$LinkSpec.url = "geo:0,0?q=" + URLEncoder.encode(strFindAddress, Constants.ENCODING);
                        arrayList.add(linkifyCompat$LinkSpec);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static String makeUrl(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify$TransformFilter linkify$TransformFilter) {
        boolean z2;
        if (linkify$TransformFilter != null) {
            str = linkify$TransformFilter.transformUrl(matcher, str);
        }
        int i = 0;
        while (true) {
            z2 = true;
            if (i >= strArr.length) {
                z2 = false;
                break;
            }
            if (str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    str = strArr[i] + str.substring(strArr[i].length());
                    break;
                }
                break;
            }
            i++;
        }
        return (z2 || strArr.length <= 0) ? str : a.J(new StringBuilder(), strArr[0], str);
    }

    private static void pruneOverlaps(ArrayList<LinkifyCompat$LinkSpec> arrayList, Spannable spannable) {
        int i;
        int i2 = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i3 = 0; i3 < uRLSpanArr.length; i3++) {
            LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
            linkifyCompat$LinkSpec.frameworkAddedSpan = uRLSpanArr[i3];
            linkifyCompat$LinkSpec.start = spannable.getSpanStart(uRLSpanArr[i3]);
            linkifyCompat$LinkSpec.end = spannable.getSpanEnd(uRLSpanArr[i3]);
            arrayList.add(linkifyCompat$LinkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i2 < size - 1) {
            LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2 = arrayList.get(i2);
            int i4 = i2 + 1;
            LinkifyCompat$LinkSpec linkifyCompat$LinkSpec3 = arrayList.get(i4);
            int i5 = linkifyCompat$LinkSpec2.start;
            int i6 = linkifyCompat$LinkSpec3.start;
            if (i5 <= i6 && (i = linkifyCompat$LinkSpec2.end) > i6) {
                int i7 = linkifyCompat$LinkSpec3.end;
                int i8 = (i7 > i && i - i5 <= i7 - i6) ? i - i5 < i7 - i6 ? i2 : -1 : i4;
                if (i8 != -1) {
                    Object obj = arrayList.get(i8).frameworkAddedSpan;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i8);
                    size--;
                }
            }
            i2 = i4;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return Build$VERSION.SDK_INT >= 28;
    }

    public static boolean addLinks(@NonNull TextView textView, int i) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!addLinks((Spannable) text, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(text);
        if (!addLinks(spannableStringValueOf, i)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(spannableStringValueOf);
        return true;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify$MatchFilter) null, (Linkify$TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify$MatchFilter linkify$MatchFilter, @Nullable Linkify$TransformFilter linkify$TransformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, linkify$MatchFilter, linkify$TransformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, linkify$MatchFilter, linkify$TransformFilter);
        }
    }

    @SuppressLint({"NewApi"})
    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify$MatchFilter linkify$MatchFilter, @Nullable Linkify$TransformFilter linkify$TransformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, strArr, linkify$MatchFilter, linkify$TransformFilter);
            return;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(spannableStringValueOf, pattern, str, strArr, linkify$MatchFilter, linkify$TransformFilter)) {
            textView.setText(spannableStringValueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify$MatchFilter) null, (Linkify$TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify$MatchFilter linkify$MatchFilter, @Nullable Linkify$TransformFilter linkify$TransformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str, linkify$MatchFilter, linkify$TransformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, linkify$MatchFilter, linkify$TransformFilter);
    }

    @SuppressLint({"NewApi"})
    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify$MatchFilter linkify$MatchFilter, @Nullable Linkify$TransformFilter linkify$TransformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str, strArr, linkify$MatchFilter, linkify$TransformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            String str2 = strArr[i];
            i++;
            strArr2[i] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z2 = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (linkify$MatchFilter != null ? linkify$MatchFilter.acceptMatch(spannable, iStart, iEnd) : true) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, linkify$TransformFilter), iStart, iEnd, spannable);
                z2 = true;
            }
        }
        return z2;
    }
}
