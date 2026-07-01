package androidx.print;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.print.PrintDocumentInfo$Builder;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
public class PrintHelper$PrintUriAdapter extends PrintDocumentAdapter {
    public PrintAttributes mAttributes;
    public Bitmap mBitmap = null;
    public final PrintHelper$OnPrintFinishCallback mCallback;
    public final int mFittingMode;
    public final Uri mImageFile;
    public final String mJobName;
    public AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
    public final /* synthetic */ PrintHelper this$0;

    public PrintHelper$PrintUriAdapter(PrintHelper printHelper, String str, Uri uri, PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback, int i) {
        this.this$0 = printHelper;
        this.mJobName = str;
        this.mImageFile = uri;
        this.mCallback = printHelper$OnPrintFinishCallback;
        this.mFittingMode = i;
    }

    public void cancelLoad() {
        synchronized (this.this$0.mLock) {
            BitmapFactory$Options bitmapFactory$Options = this.this$0.mDecodeOptions;
            if (bitmapFactory$Options != null) {
                if (Build$VERSION.SDK_INT < 24) {
                    bitmapFactory$Options.requestCancelDecode();
                }
                this.this$0.mDecodeOptions = null;
            }
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onFinish() {
        super.onFinish();
        cancelLoad();
        AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback = this.mCallback;
        if (printHelper$OnPrintFinishCallback != null) {
            printHelper$OnPrintFinishCallback.onFinish();
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback, Bundle bundle) {
        synchronized (this) {
            this.mAttributes = printAttributes2;
        }
        if (cancellationSignal.isCanceled()) {
            printDocumentAdapter$LayoutResultCallback.onLayoutCancelled();
        } else if (this.mBitmap != null) {
            printDocumentAdapter$LayoutResultCallback.onLayoutFinished(new PrintDocumentInfo$Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        } else {
            this.mLoadBitmap = new PrintHelper$PrintUriAdapter$1(this, cancellationSignal, printAttributes2, printAttributes, printDocumentAdapter$LayoutResultCallback).execute(new Uri[0]);
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter$WriteResultCallback printDocumentAdapter$WriteResultCallback) {
        this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, printDocumentAdapter$WriteResultCallback);
    }
}
