package sampleDBUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class SampleController {
	
	public static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
 // -------------------Handle POST request-------------------------------------------

    @Autowired
	IoTRepository IoTRepository;
    
 	@RequestMapping(value = "/create", method = RequestMethod.POST)
 	public Map<String,String> createSamplePostKubernetes(@RequestBody IoTDB DBdata) {
 		
 		//IoTDB IoT2DB;
 		/*IoTDB IoT2DB=new IoTDB();
 		IoT2DB.setTransportNo("WB06M5694");
 		IoT2DB.setTemp(iotdata.getTemp());
 		IoT2DB.setHumid(iotdata.getHumid());
 		IoT2DB.setLongitude(iotdata.getLongitude());
 		IoT2DB.setLatitude(iotdata.getLatitude());
 		
 		*/
 		//IoT2DB = IoTRepository.save(IoT2DB);
 		logger.info(DBdata.getLongitude()+":"+DBdata.getLatitude());
 		Date date = new Date();
 		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 		String strDate= formatter.format(date);
 		DBdata.setTravelDate(strDate);
 		DBdata = IoTRepository.save(DBdata);
 		
 		
 		Map<String,String> result = new HashMap<>();
 	    result.put("message", "Request Processed "+DBdata.getId());
 	    return result;
 	}
 	
 	
 	/**
 	  * GET /read  --> Read all records by Car# and Date from the database.
 	  */
 	 
 	 @CrossOrigin(maxAge = 3600)
 	 @RequestMapping("/read")
 	 //public Map<String, Object> read(@RequestParam String transportNo, @RequestParam String travelDate) {
 	public List<IoTDB> read(@RequestParam String transportNo, @RequestParam String travelDate) {
 		 //List<String, String> params = new List<String, String>();
 		 //params.put("transportNo", transportNo);
 		 //params.put("travelDate", travelDate);
 		 List<IoTDB> IoTDetail = IoTRepository.findByTransportNoAndTravelDate(transportNo, travelDate);
 		//List<IoTDB> IoTDetail = IoTRepository.findAll();
 		 Map<String, Object> dataMap = new HashMap<String, Object>();
 		 //dataMap.put("message", "Booking found successfully");
 		// dataMap.put("status", "1");
 		 dataMap.put("IoTDetail",IoTDetail);
 		 logger.info(IoTDetail.toString());
 	     //return dataMap;
 		return IoTDetail;
 	 }
 	
 	/**
 	  * GET /update  --> Update a IoT record and save it in the database.
 	  */
 	 
 	 @RequestMapping("/update")
 	 public Map<String, Object> update(@RequestParam String Id, @RequestParam String travelDate) {
 		IoTDB IoTDetail = IoTRepository.findOne(Id);
 		IoTDetail.setTravelDate(travelDate);
 		IoTDetail = IoTRepository.save(IoTDetail);
 		Map<String, Object> dataMap = new HashMap<String, Object>();
 		dataMap.put("message", "Booking updated successfully");
 		dataMap.put("status", "1");
 		dataMap.put("booking", IoTDetail);
 	     return dataMap;
 	 }
 	 
}