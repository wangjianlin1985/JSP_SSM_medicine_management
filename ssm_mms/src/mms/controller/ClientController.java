// 
// 
// 

package mms.controller;

import mms.pojo.EasyUIResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mms.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import mms.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({ "Client" })
@Controller
public class ClientController
{
    @Autowired
    private ClientService clientService;
    
    @RequestMapping({ "GetClient" })
    @ResponseBody
    public Client queryClientBycno(final String cno) {
        final Client client = this.clientService.queryClientBycno(cno);
        return client;
    }
    
    @RequestMapping({ "DeleteClient" })
    @ResponseBody
    public void deleteClientBycno(final String cno) {
        this.clientService.deleteClientBycno(cno);
    }
    
    @RequestMapping(value = { "DeleteRows" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String deleteClientByRows(@RequestParam("array[]") final String[] array) {
        return this.clientService.deleteClientByRows(array);
    }
    
    @RequestMapping(value = { "SaveClient" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String saveClient(final Client client) {
        return this.clientService.saveClient(client);
    }
    
    @RequestMapping({ "GetMessage" })
    @ResponseBody
    public EasyUIResult queryAllClient(@RequestParam(value = "page", defaultValue = "1") final Integer page, @RequestParam(value = "rows", defaultValue = "5") final Integer rows) {
        final EasyUIResult queryAllClient = this.clientService.queryAllClient(page, rows);
        return queryAllClient;
    }
    
    @RequestMapping(value = { "ModifyClient" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String modifyClient(final Client client) {
        if (client.getCdate() == null) {
            return "";
        }
        return this.clientService.modifyClient(client);
    }
}
