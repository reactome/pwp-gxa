[<img src=https://user-images.githubusercontent.com/6883670/31999264-976dfb86-b98a-11e7-9432-0316345a72ea.png height=75 />](https://reactome.org)

# GXA Widget
Shows a summary of the gene expression data available in Gene Expression Atlas (GXA)

<img src="https://cloud.githubusercontent.com/assets/6883670/24966498/ff09995c-1f9e-11e7-8c18-bbafc1ead865.png" align="center" alt="GXA widget example">

## How to use the widget?

First add EBI Nexus repository in your ```pom.xml``` file

```xml
    <repositories>
        ...
        <!-- EBI repo -->
        <repository>
            <id>nexus-ebi-repo</id>
            <name>The EBI internal repository</name>
            <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-repo/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
        <!-- EBI SNAPSHOT repo -->
        <repository>
            <id>nexus-ebi-snapshot-repo</id>
            <name>The EBI internal snapshot repository</name>
            <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-snapshots/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
```

Then add the GXA dependency

```xml
    <dependencies>
        ...
        <dependency>
            <groupId>uk.ac.ebi.pwp.widgets</groupId>
            <artifactId>gxa</artifactId>
            <version>3.1.1</version>
        </dependency>
    <dependencies>
```

In your project main html file add the following GXA javascript dependencies

```javascript
    <!--GXA dependencies-->
    <script language="JavaScript" type="text/javascript" src="http://www.ebi.ac.uk/gxa/resources/js-bundles/vendor.bundle.js"></script>
    <script language="JavaScript" type="text/javascript" src="http://www.ebi.ac.uk/gxa/resources/js-bundles/expression-atlas-heatmap.bundle.js"></script>
```

The GXA panel can be created as follows and then placed in the right placeholder  

```java
    GXAViewer gxaViewer = new GXAViewer();
    gxaViewer.setReactomeID("R-HSA-69580");
```
