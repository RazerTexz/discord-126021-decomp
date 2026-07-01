package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument$Page;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PrintHelper$1 extends AsyncTask<Void, Void, Throwable> {
    public final /* synthetic */ PrintHelper this$0;
    public final /* synthetic */ PrintAttributes val$attributes;
    public final /* synthetic */ Bitmap val$bitmap;
    public final /* synthetic */ CancellationSignal val$cancellationSignal;
    public final /* synthetic */ ParcelFileDescriptor val$fileDescriptor;
    public final /* synthetic */ int val$fittingMode;
    public final /* synthetic */ PrintAttributes val$pdfAttributes;
    public final /* synthetic */ PrintDocumentAdapter$WriteResultCallback val$writeResultCallback;

    public PrintHelper$1(PrintHelper printHelper, CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter$WriteResultCallback printDocumentAdapter$WriteResultCallback) {
        this.this$0 = printHelper;
        this.val$cancellationSignal = cancellationSignal;
        this.val$pdfAttributes = printAttributes;
        this.val$bitmap = bitmap;
        this.val$attributes = printAttributes2;
        this.val$fittingMode = i;
        this.val$fileDescriptor = parcelFileDescriptor;
        this.val$writeResultCallback = printDocumentAdapter$WriteResultCallback;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Throwable doInBackground(Void[] voidArr) {
        return doInBackground2(voidArr);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Throwable th) {
        onPostExecute2(th);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Throwable doInBackground2(Void... voidArr) {
        RectF rectF;
        try {
            if (this.val$cancellationSignal.isCanceled()) {
                return null;
            }
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.this$0.mContext, this.val$pdfAttributes);
            Bitmap bitmapConvertBitmapForColorMode = PrintHelper.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
            if (this.val$cancellationSignal.isCanceled()) {
                return null;
            }
            try {
                PdfDocument$Page pdfDocument$PageStartPage = printedPdfDocument.startPage(1);
                boolean z2 = PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT;
                if (z2) {
                    rectF = new RectF(pdfDocument$PageStartPage.getInfo().getContentRect());
                } else {
                    PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(this.this$0.mContext, this.val$attributes);
                    PdfDocument$Page pdfDocument$PageStartPage2 = printedPdfDocument2.startPage(1);
                    RectF rectF2 = new RectF(pdfDocument$PageStartPage2.getInfo().getContentRect());
                    printedPdfDocument2.finishPage(pdfDocument$PageStartPage2);
                    printedPdfDocument2.close();
                    rectF = rectF2;
                }
                Matrix matrix = PrintHelper.getMatrix(bitmapConvertBitmapForColorMode.getWidth(), bitmapConvertBitmapForColorMode.getHeight(), rectF, this.val$fittingMode);
                if (!z2) {
                    matrix.postTranslate(rectF.left, rectF.top);
                    pdfDocument$PageStartPage.getCanvas().clipRect(rectF);
                }
                pdfDocument$PageStartPage.getCanvas().drawBitmap(bitmapConvertBitmapForColorMode, matrix, null);
                printedPdfDocument.finishPage(pdfDocument$PageStartPage);
                if (this.val$cancellationSignal.isCanceled()) {
                    return null;
                }
                printedPdfDocument.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                return null;
            } finally {
                printedPdfDocument.close();
                ParcelFileDescriptor parcelFileDescriptor = this.val$fileDescriptor;
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                }
                if (bitmapConvertBitmapForColorMode != this.val$bitmap) {
                    bitmapConvertBitmapForColorMode.recycle();
                }
            }
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(Throwable th) {
        if (this.val$cancellationSignal.isCanceled()) {
            this.val$writeResultCallback.onWriteCancelled();
        } else if (th == null) {
            this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
        } else {
            Log.e("PrintHelper", "Error writing printed content", th);
            this.val$writeResultCallback.onWriteFailed(null);
        }
    }
}
