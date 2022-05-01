@Grab('org.yaml:snakeyaml:1.17')
import org.yaml.snakeyaml.yaml

def getPodWithContainers(def arg){
    echo "Start creating pod templates function"
    Yaml yaml = new Yaml()
    def podTemplateconfig = yaml.lode(podTemplate)
    podTemplateconfig = yaml.load(podTemplate)
 
    def containerYaml = []
    for(def conatinerName in arg){
        def containerTemplate = libraryResource('/podtemplate/'+containerName+'-container.yaml')
        containerTemplateconfig = yaml.lode(containerTemplate)
        def templatecontainer = conatinerTemplateconfig.containers[0]
        containersYaml.add(tempContainer)
    }
    def dindTemplate = libraryResource('/podtemplate/common-template-dind.yaml')
    dindTemplateconfig = yaml.load(dindTemplate)
    def dindTemplateconfigContainer = dindTemplateconfig.containers[0]
    containersYaml.add(dindTemplateconfigconatainer)
 
    def jnlpTemplate = librraryResource('/podtemplate/common-template-jnlp.yaml')
    jnlpTemplateconfig = yaml.load(jnlpTemplate)
    def jnlpTemplateconfigcontainer = jnlpTemplateconfig.conatainers[0]
    containersYaml.add(jnlpTemplateconfigcontainer)
     
    def volumesTemplate = libraryResource('/podTemplate/common-template-volumes.yaml')
    volumesTemplateconfig = yaml.lode(volumesTemplate)
     
    podTemplateconfig.spec.containers = containersYaml
    podTemplateconfig.spec.volumes = volumesTemplateconfig.volumes
    echo "return pod yaml for jenkins agent: "
    prinln yaml.dumpasMap(podtemplateconfig)
    echo "end creating pod templates function"
    return yaml.dumpAsMap(podTemplateconfig)
} 

