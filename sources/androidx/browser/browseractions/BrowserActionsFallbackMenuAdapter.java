package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R$id;
import androidx.browser.R$layout;
import androidx.core.content.res.ResourcesCompat;
import b.i.b.d.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    public BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mMenuItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mMenuItems.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BrowserActionsFallbackMenuAdapter$ViewHolderItem browserActionsFallbackMenuAdapter$ViewHolderItem;
        BrowserActionItem browserActionItem = this.mMenuItems.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R$layout.browser_actions_context_menu_row, (ViewGroup) null);
            ImageView imageView = (ImageView) view.findViewById(R$id.browser_actions_menu_item_icon);
            TextView textView = (TextView) view.findViewById(R$id.browser_actions_menu_item_text);
            if (imageView == null || textView == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            browserActionsFallbackMenuAdapter$ViewHolderItem = new BrowserActionsFallbackMenuAdapter$ViewHolderItem(imageView, textView);
            view.setTag(browserActionsFallbackMenuAdapter$ViewHolderItem);
        } else {
            browserActionsFallbackMenuAdapter$ViewHolderItem = (BrowserActionsFallbackMenuAdapter$ViewHolderItem) view.getTag();
        }
        String title = browserActionItem.getTitle();
        browserActionsFallbackMenuAdapter$ViewHolderItem.mText.setText(title);
        if (browserActionItem.getIconId() != 0) {
            browserActionsFallbackMenuAdapter$ViewHolderItem.mIcon.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem.getIconId(), null));
        } else if (browserActionItem.getIconUri() != null) {
            a<Bitmap> aVarLoadBitmap = BrowserServiceFileProvider.loadBitmap(this.mContext.getContentResolver(), browserActionItem.getIconUri());
            aVarLoadBitmap.addListener(new BrowserActionsFallbackMenuAdapter$1(this, title, browserActionsFallbackMenuAdapter$ViewHolderItem, aVarLoadBitmap), new BrowserActionsFallbackMenuAdapter$2(this));
        } else {
            browserActionsFallbackMenuAdapter$ViewHolderItem.mIcon.setImageBitmap(null);
            browserActionsFallbackMenuAdapter$ViewHolderItem.mIcon.setVisibility(4);
        }
        return view;
    }
}
