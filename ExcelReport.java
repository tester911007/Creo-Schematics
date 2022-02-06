import rsdesigner.component.Artifact;
import rsdesigner.component.Shape;
import rsdesigner.design.RSDException;
import rsdesigner.design.Sheet;

import java.util.Iterator;

public class ExcelReport {
    /**
     * Вызов метода - метка листа {ExcelReport.print_all_artifact_attributes()}
     *
     * @param sheet - параметр, который не надо передавать в метод.
     */
    public static String print_all_artifact_attributes(Sheet sheet) {
        System.out.println("{ExcelReport.print_all_artifact_attributes()}");

        try {
            for (String property : sheet.getShapes().next().getArtifact().getProperties()) {
                System.out.println(property);
            }
        } catch (RSDException e) {
            System.out.println("Возникла ошибка: " + e);
        }
        return "Текст для метки на листе";
    }

    /**
     * Вызов метода - метка листа {ExcelReport.report_method(название атрибута)}
     *
     * @param sheet - параметр, который не надо передавать в метод
     * @param attribute_name  - название атрибука, значение которого требуется вывести в консоль
     */
    public static String report_method(Sheet sheet, String attribute_name) throws RSDException {
        System.out.printf("{ExcelReport.report_method(%s)}\n", attribute_name);

        Artifact artifact;

        Iterator<Shape> shapes = sheet.getShapes();
        while (shapes.hasNext()) {
            try {
                artifact = shapes.next().getArtifact();
                System.out.println(artifact.getProperty(attribute_name));
            } catch (Exception e) {
                System.out.println("Возникла ошибка: " + e);
            }
        }
        return "Текст для метки на листе";
    }
}
